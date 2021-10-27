package Objetos;

public class Ferreteria {
    private int id;
    private String[] material = {"Cemento","Lija","Lija fina","Pintura en Spray","Pinturas", "Puertas", "Listones de madera", "Plancha de madera", "Tabla de zinc","Tabla de internit","Tabla de madera","Guantes","Cables","Clavos",
            "Pernos","Tornillos","Casco","Carretilla","Ladrillo","Tarugos","Diluyente","Enchufes","Interructores", "Melamina","Tiradores","Rieles","Visagras","Guias telescopia","Barras de colgar","Soporte de barra","Tapacanto",
            "Agorex","Escuadras plasticas"};

    private String[] herramienta ={"Alicate", "Serrucho", "Brocha", "Huincha de medir","Llave Francesa","Multimetro digital","Desortillador","Taladro electrico","Escuadra",
                                   "Martillo","Sierra Manual","Sierra electrica","Sierra Caladora","Pala","Llave de tubo",
                                   "Nivel","Corte de ceramica","Broca","Broca de paleta"};

    private String[] manual ={"Pintar mesa", "Instalar ventilador de techo", "Arreglar regadera", "Instalación de luz", "Armar closet", "Armar repisa"," Armar despensa","Colocar Ceramica",
                              "Instalar llave de agua","Techo","Encialado de madera","Encialado de cemento","Cañaria del agua", "Estanque de baño ",
                               "Ducha electrica", "Lava manos", "Tasa de baño","Cañaria de agua"};

    private int[] preciosma = {3500, 4000, 3500, 10000, 5500, 15000, 2000, 2500,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000};
    private int[] preciosher ={1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000,1000};

    private int stock;

    public Ferreteria() {
    }

    public Ferreteria(int id, String[] material, String[] herramienta, String[] manual, int[] preciosma, int[] preciosher, int stock) {
        this.id = id;
        this.material = material;
        this.herramienta = herramienta;
        this.manual = manual;
        this.preciosma = preciosma;
        this.preciosher = preciosher;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getMaterial() {
        return material;
    }

    public void setMaterial(String[] material) {
        this.material = material;
    }

    public String[] getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(String[] herramienta) {
        this.herramienta = herramienta;
    }

    public String[] getManual() {
        return manual;
    }

    public void setManual(String[] manual) {
        this.manual = manual;
    }

    public int[] getPreciosma() {
        return preciosma;
    }

    public void setPreciosma(int[] preciosma) {
        this.preciosma = preciosma;
    }

    public int[] getPreciosher() {
        return preciosher;
    }

    public void setPreciosher(int[] preciosher) {
        this.preciosher = preciosher;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    //regla
    public int adicional(int valor, int adicional){
        return valor + adicional;
    }
}

