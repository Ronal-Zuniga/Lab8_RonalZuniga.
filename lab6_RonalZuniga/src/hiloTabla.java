
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class hiloTabla extends Thread {

    private JTable tabla;
    private ArrayList<Programa> programas = new ArrayList();

    public hiloTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public hiloTabla() {
    }

    public JTable getTabla() {
        return tabla;
    }

    public void setTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public ArrayList<Programa> getProgramas() {
        return programas;
    }

    public void setProgramas(ArrayList<Programa> programas) {
        this.programas = programas;
    }

    @Override
    public void run() {
        DefaultTableModel m = (DefaultTableModel) tabla.getModel();
        for (int i = 0; i < programas.size(); i++) {
            Object[] t = {
                programas.get(i).getNombre(), programas.get(i).getPuntuacion(),
                programas.get(i).getLanzamiento(), programas.get(i).getTipo(),
                programas.get(i).getGenero()
            };
            m.addRow(t);
        }
        tabla.setModel(m);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(hiloTabla.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
