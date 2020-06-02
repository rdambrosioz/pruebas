public class BusLine {

    private String empresa;
    private Long idLinea;
    private String numeroDeLinea;
    private Integer direccion;
    private Long idOrigen;
    private String nombreOrigen;
    private Long idDestino;
    private String nombreDestino;

    public BusLine(String empresa, Long idLinea, String numeroDeLinea, Integer direccion, Long idOrigen, String nombreOrigen, Long idDestino, String nombreDestino) {
        this.empresa = empresa;
        this.idLinea = idLinea;
        this.numeroDeLinea = numeroDeLinea;
        this.direccion = direccion;
        this.idOrigen = idOrigen;
        this.nombreOrigen = nombreOrigen;
        this.idDestino = idDestino;
        this.nombreDestino = nombreDestino;
    }


    public BusLine(String[] arguments){
        this.empresa = arguments[0];
        this.idLinea = Long.parseLong(arguments[1]);
        this.numeroDeLinea = arguments[2];
        this.direccion = Integer.parseInt(arguments[3]);
        this.idOrigen = Long.parseLong(arguments[4]);
        this.nombreOrigen = arguments[5];
        this.idDestino = Long.parseLong(arguments[6]);
        this.nombreDestino = arguments[7];
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public Long getIdLinea() {
        return idLinea;
    }

    public void setIdLinea(Long idLinea) {
        this.idLinea = idLinea;
    }

    public String  getNumeroDeLinea() {
        return numeroDeLinea;
    }

    public void setNumeroDeLinea(String numeroDeLinea) {
        this.numeroDeLinea = numeroDeLinea;
    }

    public Integer getDireccion() {
        return direccion;
    }

    public void setDireccion(Integer direccion) {
        this.direccion = direccion;
    }

    public Long getIdOrigen() {
        return idOrigen;
    }

    public void setIdOrigen(Long idOrigen) {
        this.idOrigen = idOrigen;
    }

    public String getNombreOrigen() {
        return nombreOrigen;
    }

    public void setNombreOrigen(String nombreOrigen) {
        this.nombreOrigen = nombreOrigen;
    }

    public Long getIdDestino() {
        return idDestino;
    }

    public void setIdDestino(Long idDestino) {
        this.idDestino = idDestino;
    }

    public String getNombreDestino() {
        return nombreDestino;
    }

    public void setNombreDestino(String nombreDestino) {
        this.nombreDestino = nombreDestino;
    }

    @Override
    public String toString() {
        return  "empresa: " + empresa + "\n" +
                "idLinea: " + idLinea + "\n" +
                "numeroDeLinea: " + numeroDeLinea + "\n" +
                "direccion: " + direccion + "\n" +
                "idOrigen: " + idOrigen + "\n" +
                "nombreOrigen: " + nombreOrigen + "\n" +
                "idDestino: " + idDestino + "\n" +
                "nombreDestino: " + nombreDestino + "\n" +
                "\n\n";
    }
}
