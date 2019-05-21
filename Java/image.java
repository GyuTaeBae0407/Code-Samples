package asd;

import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

class image
{
    public static void main(String[] args)
    {
        BufferedImage imgA = null;
        BufferedImage imgB = null;
        
        int width1 = 0;
        int width2 = 0;
        int height1 = 0;
        int height2 = 0;

        try
        {
            File fileA = new File("image1.jpg");
            File fileB = new File("image2.jpg");
            
            imgA = ImageIO.read(new File("image1.jpg"));
            imgB = ImageIO.read(new File("image2.jpg"));

                      
            width1 = imgA.getWidth();
            width2 = imgB.getWidth();
            height1 = imgA.getHeight();
            height2 = imgB.getHeight();
        }
        catch (IOException e)
        {
            System.out.println(e);
        }
        
 

        if ((width1 != width2) || (height1 != height2))
            System.out.println("Error: Images dimensions"+
                    " mismatch");
        else
        {
            long difference = 0;
            for (int y = 0; y < height1; y++)
            {
                for (int x = 0; x < width1; x++)
                {
                    int rgbA = imgA.getRGB(x, y);
                    int rgbB = imgB.getRGB(x, y);
                    int redA = (rgbA >> 16) & 0xff;
                    int greenA = (rgbA >> 8) & 0xff;
                    int blueA = (rgbA) & 0xff;
                    int redB = (rgbB >> 16) & 0xff;
                    int greenB = (rgbB >> 8) & 0xff;
                    int blueB = (rgbB) & 0xff;
                    difference += Math.abs(redA - redB);
                    difference += Math.abs(greenA - greenB);
                    difference += Math.abs(blueA - blueB);
                }
            }

            double total_pixels = width1 * height1 * 3;

            double avg_different_pixels = difference /
                    total_pixels;

            double percentage = (avg_different_pixels /
                    255) * 100;

            System.out.println("Difference Percentage-->" +
                    percentage);
        }
    }
}