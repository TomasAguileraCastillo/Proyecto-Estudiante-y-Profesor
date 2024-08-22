package cl.praxis.EjercicioSpring.model;

public class Teacher {
    //Atributos
    private int idT;
    private String nameT;
    private String lastNameT;
    private String courseNameT;


    //Constructor Vacio
    public Teacher() {
    }

    //Constructor Completo
    public Teacher(int idT, String nameT, String lastNameT, String courseNameT) {
        this.idT = idT;
        this.nameT = nameT;
        this.lastNameT = lastNameT;
        this.courseNameT = courseNameT;
    }

    //Metodos

    @Override
    public String toString() {
        return "Teacher{" +
                "idT=" + idT +
                ", nameT='" + nameT + '\'' +
                ", lastNameT='" + lastNameT + '\'' +
                ", courseNameT='" + courseNameT + '\'' +
                '}';
    }


    //Getters y Setters


    public int getIdT() {
        return idT;
    }

    public void setIdT(int idT) {
        this.idT = idT;
    }

    public String getNameT() {
        return nameT;
    }

    public void setNameT(String nameT) {
        this.nameT = nameT;
    }

    public String getLastNameT() {
        return lastNameT;
    }

    public void setLastNameT(String lastNameT) {
        this.lastNameT = lastNameT;
    }

    public String getCourseNameT() {
        return courseNameT;
    }

    public void setCourseNameT(String courseNameT) {
        this.courseNameT = courseNameT;
    }
}