package Objetos;

public class Ferreteria {
    private int id;
    private String[] material = {"Cemento","Lija","Pintura en Spray","Barniz", "Puertas", "Listones de madera", "Terciado", "Plancha de zinc", "Plancha de internit", "Guantes de fibra", "Cables electrico","Bolsa de clavos",
            "Caja de pernos","Caja de tornillos","Casco de seguridad","Carretilla de acero","Bolsa de tarugos","Botella de diluyente","Interructores triple","Caja de bisagras","Tablero melaminado"};

    private String[] herramienta ={"Alicate", "Serrucho", "Brocha", "Huincha de medir","Llave Francesa","Multimetro digital","Desortillador manual","Taladro electrico","Escuadra",
                                   "Martillo de fibra","Sierra Manual","Sierra electrica","Sierra Caladora","Pala de punta",
                                   "Kits de niveles","Kit de instalación de ceramica","Broca para madera","Kits de soldadora"};

    private String[] manual ={"Pintar mesa", "Instalar ventilador de techo", "Instalación de luz", "Colocar Ceramica"};
    private int[] preciosma = {8000, 6500, 5000, 10000, 30000, 25000, 22000, 15000, 27000, 7500, 7000, 12000, 17000, 14000, 3000, 27000, 12000, 7000, 16000,4000,4000, 8500, 24000};
    private int[] preciosher ={5000, 8000, 4000, 2500, 9000, 16000, 12000, 40000, 3100, 15000, 6500, 100000, 50000, 10000, 4100, 130000,18000,150000};

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

