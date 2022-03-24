import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Welcome {

    void menu() {
        System.out.println("This is Welcome Menu");
    }

    void welcome() throws IOException {
        Scanner entry = new Scanner(System.in);
        System.out.print("ENTER USERNAME: ");
        String username = entry.nextLine();
        System.out.print("ENTER PASSWORD: ");
        String password = entry.nextLine();
        entry.close();

        if(verify(username, password)) menu();
        else System.out.println("Wrong password");
        

    }

    boolean verify(String username, String password) throws IOException {

        // opening the file and loading it into the scanner
        File detailsFile = new File("userDetails.csv");
        Scanner reader = new Scanner(detailsFile);
        reader.useDelimiter("\n");
        // reading the lines in the file
        while(reader.hasNext()) {
            String[] contents = reader.next().split(",");
            if (contents[0].trim().equals(username) && contents[1].trim().equals(password))
                return true;
        }
        reader.close();
        return false;

    }

    public static void main(String[] args) throws IOException{
        System.out.println("Testing");
        Welcome test = new Welcome();
        test.welcome();
    }
}