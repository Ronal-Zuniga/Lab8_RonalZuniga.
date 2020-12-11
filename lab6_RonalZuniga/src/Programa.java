
public class Programa {

    private String nombre;
    private int puntuacion;
    private int lanzamiento;
    private String tipo;
    private String genero;

    public Programa() {
    }

    public Programa(String nombre, int puntuacion, int lanzamiento, String tipo, String genero) {
        this.nombre = nombre;
        setPuntuacion(puntuacion);
        setLanzamiento(lanzamiento);
        setTipo(tipo);
        this.genero = genero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        if (puntuacion >= 1 && puntuacion <= 10) {
            this.puntuacion = puntuacion;
        }
    }

    public int getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(int lanzamiento) {
        if (lanzamiento > 1900 && lanzamiento <= 2020) {
            this.lanzamiento = lanzamiento;
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (tipo.equals("Anime") || tipo.equals("Serie") || tipo.equals("Documental") || tipo.equals("Pelicula")) {
            this.tipo = tipo;
        }
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        if (genero.equals("Comedia") || genero.equals("Romance") || genero.equals("Terror")
                || genero.equals("SyFy") || genero.equals("Suspenso") || genero.equals("Accion")) {
            this.genero = genero;
        }
    }

    @Override
    public String toString() {
        return nombre + ",  " + tipo + ",  " + genero;
    }
    

}
