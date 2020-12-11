
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class adminClaudilist {

    private ArrayList<Programa> programas = new ArrayList();
    private File archivo = null;

    public adminClaudilist(String path) {
        this.archivo = new File(path);
    }
    
    public adminClaudilist() {
        
    }

    public ArrayList<Programa> getProgramas() {
        return programas;
    }

    public void setProgramas(ArrayList<Programa> programas) {
        this.programas = programas;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

    public void setPrograma(Programa p) {
        this.programas.add(p);
    }

    public void escribirArchivo() throws IOException {
        FileWriter fw = null;
        BufferedWriter bw = null;
        try {
            fw = new FileWriter(archivo, false);
            bw = new BufferedWriter(fw);
            for (Programa p : programas) {
                bw.write(p.getNombre() + "/");
                bw.write(p.getPuntuacion() + "/");
                bw.write(p.getLanzamiento() + "/");
                bw.write(p.getTipo() + "/");
                bw.write(p.getGenero() + "/");
            }
            bw.flush();
        } catch (Exception ex) {
        }
        bw.close();
        fw.close();
    }

    public void cargarArchivo() {
        Scanner sc = null;
        programas = new ArrayList();
        if (archivo.exists()) {
            try {
                sc = new Scanner(archivo);
                sc.useDelimiter("/");
                while (sc.hasNext()) {
                    programas.add(new Programa(sc.next(), sc.nextInt(), sc.nextInt(), sc.next(), sc.next()));
                }
            } catch (Exception ex) {
            }
            sc.close();
        }
    }
}
