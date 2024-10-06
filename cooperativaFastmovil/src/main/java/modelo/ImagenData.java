package modelo;

public class ImagenData {
	
	private byte[] imageBytes;
    private String tipoImagen;

    public ImagenData(byte[] imageBytes, String tipoImagen) {
        this.imageBytes = imageBytes;
        this.tipoImagen = tipoImagen;
    }

    public byte[] getImageBytes() {
        return imageBytes;
    }

    public String gettipoImagen() {
        return tipoImagen;
    }
}
