public class Image extends Item{

    private int width;
    private int height;
    Image(String name, String path){
        super(name,path);
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }
}