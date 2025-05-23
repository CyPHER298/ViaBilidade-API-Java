package br.com.fiap.beans;

public class Cargo {
    private int id;
    private String nm_cargo;
    private int lvl_cargo;

    @Override
    public String toString() {
        return "Cargo: " + nm_cargo + "," + "Nível do cargo: " + lvl_cargo;}

    public Cargo(){
        super();
    }

    public Cargo(int id, int lvl_cargo, String nm_cargo) {
        this.id = id;
        this.lvl_cargo = lvl_cargo;
        this.nm_cargo = nm_cargo;
    }

    public String getNm_cargo() {
        return nm_cargo;
    }

    public void setNm_cargo(String nm_cargo) {
        this.nm_cargo = nm_cargo;
    }

    public int getLvl_cargo() {
        return lvl_cargo;
    }

    public void setLvl_cargo(int lvl_cargo) {
        this.lvl_cargo = lvl_cargo;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
}
