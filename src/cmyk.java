/**
 * Created by asus on 07-Aug-17.
 */
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.awt.*;
import java.math.*;

public class cmyk {
    public static float [] rgb2cmyk(int red , int green , int blue){

        int r = red , g = green , b = blue ;
        float rr , gg , bb ;
        rr = (float)r/255;
        gg = (float)g/255;
        bb = (float)b/255;
        float k =0 , c=0  , m =0 , y=0;

        k = (float) 1 -Math.max(rr  , Math.max(gg , bb));
        c = (float)(1 - rr - k)/(1-k);
        m = (float) (1 - gg -k )/(1-k);
        y = (float) (1 -bb -k)/(1-k);

    return   new float [] {c , m , y  , k };
    }

    public static void main (String []args){

        BufferedImage img = null ;
        File f = null ;
        int red  , green , blue  ;
        try {
            f = new File("D:\\Image\\Taj.jpg");
            img = ImageIO.read(f);
        }catch (IOException e ){
          //  System.out.println("Error " +e);
        }
        for (int i = 0 ; i<img.getHeight()  ;i++){
            for (int j = 0 ; j<img.getWidth() ;j++){
                red = new Color(img.getRGB(i , j)).getRed();
                green = new Color (img.getRGB(i , j)).getGreen();
                blue = new Color (img.getRGB(i , j)).getBlue();

                float  cmyk [] =new float [4];
                for (int x = 0  ; x < 4  ; x++){
                    cmyk = rgb2cmyk(red , green , blue );
                    System.out.println("Rgb [" +red+ ","+green +","+blue +"] to cmyk ["+cmyk[0]+","+cmyk[1]+","+cmyk[2]+","+cmyk[3]+"]");
                }

            }
        }


    }


}
