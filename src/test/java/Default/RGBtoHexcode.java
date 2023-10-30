package Default;

public class RGBtoHexcode {

    public static void main(String[] args) {


        String rgb = "rgb(0, 82, 155)";
        rgb = rgb.replaceAll("[^0-9& ]", "");
        String[] split = rgb.split(" ");

        System.out.println(rgb);

        int red = Integer.parseInt(split[0]);
        int green = Integer.parseInt(split[1]);
        int blue = Integer.parseInt(split[2]);

        String hexColor = String.format("#%02X%02X%02X", red, green, blue);

        System.out.println("Hexadecimal Color Code: " + hexColor);
    }

}