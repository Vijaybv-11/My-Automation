/*
package OpenCV;
import org.opencv.core.Core;
import org.opencv.core.CvType;
import org.opencv.core.Mat;
import org.opencv.core.MatOfFloat;
import org.opencv.core.MatOfInt;
import org.opencv.core.Scalar;
import org.opencv.core.Size;
import org.opencv.core.CvType.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

import java.util.ArrayList;
import java.util.List;
public class GetColorOfImage {

    public static void main(String[] args) {

                System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

                // Path to your image
                String imagePath = "C:\\Users\\Vijay\\Downloads\\Red.png";

                // Load the image
                Mat image = Imgcodecs.imread(imagePath);

                // Resize the image to reduce computation (optional)
                int maxWidthOrHeight = 1000;
                image = resizeImage(image, maxWidthOrHeight);

                // Convert the image to LAB color space
                Mat labImage = new Mat();
                Imgproc.cvtColor(image, labImage, Imgproc.COLOR_BGR2Lab);

                // Calculate histogram of the LAB image
                List<Mat> labChannels = new ArrayList<>();
                Core.split(labImage, labChannels);

                MatOfInt histSize = new MatOfInt(256);
                MatOfFloat histRange = new MatOfFloat(0, 256);
                Mat hist = new Mat();
                Imgproc.calcHist(labChannels.subList(1, 3), new MatOfInt(1, 2), new Mat(), hist, histSize, histRange, false);

                // Find the dominant color bin index
                int maxBinIndex = 0;
                double maxBinValue = 0;
                for (int i = 0; i < hist.rows(); i++) {
                    double binValue = hist.get(i, 0)[0];
                    if (binValue > maxBinValue) {
                        maxBinIndex = i;
                        maxBinValue = binValue;
                    }
                }

                // Calculate the dominant color in BGR space
                Mat dominantColorLab = new Mat(1, 1, CvType.CV_32FC3, new Scalar(maxBinIndex, 128, 128));
                Mat dominantColorBgr = new Mat();
                Imgproc.cvtColor(dominantColorLab, dominantColorBgr, Imgproc.COLOR_Lab2BGR);

                // Print the dominant color values
                double[] dominantColorBgrValues = dominantColorBgr.get(0, 0);
                int b = (int) dominantColorBgrValues[0];
                int g = (int) dominantColorBgrValues[1];
                int r = (int) dominantColorBgrValues[2];
                System.out.println("Dominant Color (BGR): " + b + ", " + g + ", " + r);
            }

            private static Mat resizeImage(Mat image, int maxWidthOrHeight) {
                double aspectRatio = (double) image.cols() / image.rows();
                int targetWidth = maxWidthOrHeight;
                int targetHeight = (int) (targetWidth / aspectRatio);
                if (targetHeight > maxWidthOrHeight) {
                    targetHeight = maxWidthOrHeight;
                    targetWidth = (int) (targetHeight * aspectRatio);
                }
                Size targetSize = new Size(targetWidth, targetHeight);
                Mat resizedImage = new Mat();
                Imgproc.resize(image, resizedImage, targetSize, 0, 0, Imgproc.INTER_AREA);
                return resizedImage;
            }
        }


*/
