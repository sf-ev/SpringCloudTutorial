package springCloudTut.limitsservice.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.stereotype.Service;

import java.io.*;

@Service
public class FileReaderService {

    public String readFile() throws IOException {
        //InputStream
        InputStream input = null;

        var file = new File("C:\\Users\\s.frank\\OneDrive - evia solutions GmbH\\Desktop\\text.txt");

        int i;
        char c;
        String textfile = null;

        try {
            input = new FileInputStream(file);

            //solange inhalt ist kein -1
            while ((i = input.read()) != -1) {
                c = (char) i;
                textfile = textfile + c;

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            //Stream immmer schließen
            input.close();
        }
        
        return textfile;
    }

    public File writeFile() throws IOException {
        var file = new File("C:\\Users\\s.frank\\OneDrive - evia solutions GmbH\\Desktop\\text.txt");
        OutputStream outputStream = null;
        String text = "<--Was Soll das ueberhaupt-->";
        try {
            outputStream = new FileOutputStream(file);
            outputStream.write(text.getBytes());

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            outputStream.close();
        }
        return file;
    }


}
