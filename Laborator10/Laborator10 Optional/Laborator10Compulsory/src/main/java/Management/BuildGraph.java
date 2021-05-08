package Management;

import Models.Friendships;
import Models.User;
import Repositories.FriendshipRepository;
import Repositories.UserRepository;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import org.jgrapht.Graph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.jgrapht.nio.dot.DOTExporter;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildGraph {
    final UserRepository userRepository = new UserRepository();
    final FriendshipRepository friendshipRepository = new FriendshipRepository();
    public Graph<String, DefaultEdge> createStringGraph()
    {
        Graph<String, DefaultEdge> g = new SimpleGraph<>(DefaultEdge.class);

        List<Object> friendships = friendshipRepository.getAll();
        for (Object friendship : friendships) {
            g.addVertex(((User)userRepository.findById(((Friendships) friendship).getUser2())).getName());
        }

        for (Object friendship : friendships) {
            g.addEdge(((User)userRepository.findById(((Friendships) friendship).getUser1())).getName(), ((User)userRepository.findById(((Friendships) friendship).getUser2())).getName());
        }

        Map<String, Object> root = new HashMap<>();
        DOTExporter<String, DefaultEdge> exporter2=new DOTExporter<>(v -> v.toString());
        Writer writer = new StringWriter();
        exporter2.exportGraph(g, writer);
//        System.out.println(writer);
        root.put("content", writer);
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_29);
        try {
            cfg.setDirectoryForTemplateLoading(new File("C:\\Users\\Gabi\\Desktop\\PA\\Laborator10\\Laborator10Compulsory\\src\\main\\resources\\templates"));
            cfg.setDefaultEncoding("UTF-8");
            cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
            cfg.setLogTemplateExceptions(false);
            cfg.setWrapUncheckedExceptions(true);
            cfg.setFallbackOnNullLoopVariable(false);
            Template temp = cfg.getTemplate("graph.html");
            File file = new File("C:\\Users\\Gabi\\Desktop\\PA\\Laborator10\\Laborator10Compulsory\\src\\main\\resources\\templates\\graph.html");
            Writer out = new OutputStreamWriter(new FileOutputStream(file));
            temp.process(root, out);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TemplateException e) {
            e.printStackTrace();
        }

        return g;
    }
}
