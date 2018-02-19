package main.java.by.tc.task03.main;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ResourcesPath {// ну и зачем тут такая мутатень, тебя джарку попросили показать, как ее анализатор работает
    // зачем вокруг простой задачи сооружать какофонию

    private static final String resourceDatabasePath;

    FileInputStream fstream;// атрибуты доступа где?

    BufferedReader buffer = null;

    static {
        resourceDatabasePath = "../resource_path.txt";
    }

    public String takePath(String typeOfFile) throws IOException{


            String resourcePathInfo;

            String path;

            fstream = new FileInputStream(resourceDatabasePath);

            buffer = new BufferedReader(new InputStreamReader(fstream));

            while((resourcePathInfo = buffer.readLine()) != null){

                String filePurpose = resourcePathInfo.split("[=]")[0].toLowerCase();

                if(typeOfFile.toLowerCase().equals(filePurpose.toLowerCase())){

                    path = resourcePathInfo.split("[=]")[1].toLowerCase();

                    return path;
                }

            }

            return null;
    }
}
