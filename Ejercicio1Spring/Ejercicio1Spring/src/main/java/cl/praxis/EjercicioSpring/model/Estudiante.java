package cl.praxis.EjercicioSpring.model;

public class Estudiante {
    //Atributos
    private int id;
    private String name;
    private String lastName;

    //Constructor Vacio
    public Estudiante() {
    }

    //Constructor Completo
    public Estudiante(int id, String name, String lastName) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
    }

    //Metodos

    @Override
    public String toString() {
        return "Estudiante{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }



    //Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
