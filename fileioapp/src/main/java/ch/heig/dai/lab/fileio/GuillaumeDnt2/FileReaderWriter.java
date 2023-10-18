package ch.heig.dai.lab.fileio.GuillaumeDnt2;

import java.io.*;
import java.nio.charset.Charset;

public class FileReaderWriter {

    /**
     * Read the content of a file with a given encoding.
     * @param file the file to read. 
     * @param encoding
     * @return the content of the file as a String, or null if an error occurred.
     */
    public String readFile(File file, Charset encoding) {
        // TODO: Implement the method body here. 
        // Use the ...Stream and ...Reader classes from the java.io package.
        // Make sure to close the streams and readers at the end.
        String content = "";

        try(var r = new BufferedReader(
                        new InputStreamReader(
                            new FileInputStream(file), encoding))){
                String line;
                while((line = r.readLine()) != null){
                    content += line + "\n";
                }

        }catch (Exception e){
            return null;
        }


        return content;
    }

    /**
     * Write the content to a file with a given encoding. 
     * @param file the file to write to
     * @param content the content to write
     * @param encoding the encoding to use
     * @return true if the file was written successfully, false otherwise
     */
    public boolean writeFile(File file, String content, Charset encoding) {
        // TODO: Implement the method body here. 
        // Use the ...Stream and ...Reader classes from the java.io package.
        // Make sure to flush the data and close the streams and readers at the end.
        try(var w = new BufferedWriter(
                        new OutputStreamWriter(
                            new FileOutputStream(file),
                            encoding))){
            w.write(content);
        }
        catch(Exception e){
            return false;
        }

        return true;
    }
}
