import java.util.ArrayList;
import java.util.List;



abstract class FileSystemComponent {
     protected String name;

     public FileSystemComponent(String name) {
          this.name = name;
     }

     public abstract void display(String indent);
     public abstract int getSize();

     public void add(FileSystemComponent component) throws UnsupportedOperationException {
          throw new UnsupportedOperationException("Cannot add component to this type.");
     }

     public void remove(FileSystemComponent component) throws UnsupportedOperationException {
          throw new UnsupportedOperationException("Cannot remove component from this type.");
     }

     public boolean contains(FileSystemComponent component) throws UnsupportedOperationException {
          throw new UnsupportedOperationException("Operation not supported.");
     }
}


class File extends FileSystemComponent {
     private int size;

     public File(String name, int size) {
          super(name);
          this.size = size;
     }

     @Override
     public void display(String indent) {
          System.out.println(indent + "File: " + name + " (" + size + " KB)");
     }

     @Override
     public int getSize() {
          return size;
     }
}


class Directory extends FileSystemComponent {
     private List<FileSystemComponent> children;

     public Directory(String name) {
          super(name);
          children = new ArrayList<>();
     }

     @Override
     public void display(String indent) {
          System.out.println(indent + "Directory: " + name);
          for (FileSystemComponent component : children) {
               component.display(indent + "  ");
          }
     }

     @Override
     public int getSize() {
          int totalSize = 0;
          for (FileSystemComponent component : children) {
               totalSize += component.getSize();
          }
          return totalSize;
     }

     @Override
     public void add(FileSystemComponent component) {
          if (!contains(component)) {
               children.add(component);
               System.out.println(component.name + " added to " + name);
          } else {
               System.out.println(component.name + " already exists in " + name);
          }
     }

     @Override
     public void remove(FileSystemComponent component) {
          if (contains(component)) {
               children.remove(component);
               System.out.println(component.name + " removed from " + name);
          } else {
               System.out.println(component.name + " not found in " + name);
          }
     }

     @Override
     public boolean contains(FileSystemComponent component) {
          return children.contains(component);
     }
}





public class Composite {
     public static void main(String[] args) {
          Directory root = new Directory("Root");

          File file1 = new File("File1.txt", 10);
          File file2 = new File("File2.txt", 20);
          Directory subDir1 = new Directory("SubDir1");
          Directory subDir2 = new Directory("SubDir2");

          File file3 = new File("File3.txt", 30);
          File file4 = new File("File4.txt", 40);


          root.add(file1);
          root.add(subDir1);
          root.add(file2);

          subDir1.add(file3);
          subDir2.add(file4);

          root.add(subDir2);


          System.out.println("File System Structure:");
          root.display("");
     }
}
