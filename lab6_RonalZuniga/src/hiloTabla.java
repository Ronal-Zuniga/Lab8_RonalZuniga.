
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class hiloTabla extends Thread {

    private JTable tabla;
    private ArrayList<Programa> programas = new ArrayList();
    private boolean refresh;

    public hiloTabla(JTable tabla) {
        this.tabla = tabla;
    }

    public hiloTabla() {
    }

    public boolean isRefresh() {
        return refresh;
    }

    public void setRefresh(boolean refresh) {
        this.refresh = refresh;
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
        int x = programas.size();
        int y = 0;
        if (refresh) {
            DefaultTableModel m = (DefaultTableModel) tabla.getModel();
            for (int i = 0; i < programas.size(); i++) {
                Object[] t = {
                    programas.get(i).getNombre(), programas.get(i).getPuntuacion(),
                    programas.get(i).getLanzamiento(), programas.get(i).getTipo(),
                    programas.get(i).getGenero()
                };
                m.addRow(t);
                tabla.setModel(m);
            }
            refresh = false;
        } else {
            while (y < x) {
                DefaultTableModel m = (DefaultTableModel) tabla.getModel();
                Object[] t = {
                    programas.get(y).getNombre(), programas.get(y).getPuntuacion(),
                    programas.get(y).getLanzamiento(), programas.get(y).getTipo(),
                    programas.get(y).getGenero()
                };
                m.addRow(t);
                y++;
                tabla.setModel(m);
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(hiloTabla.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
}
