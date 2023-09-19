package tw.com.tools;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class ImageTools {
	private static String imagePath;
	static void setImagePath(String path) {
		imagePath = path;
	}
	public static String getImagePath() {
		return imagePath;
	}
	public static boolean uploadFile(InputStream inputStr,String fileName) throws IOException {
		String fileDir = getImagePath()+File.separator+fileName;
		File outFile = new File(fileDir);
		try(BufferedInputStream bfIn = new BufferedInputStream(inputStr);
			FileOutputStream fOut = new FileOutputStream(outFile)){
			byte[] cache = new byte[1024];
			int index = -1;
			while((index =  bfIn.read(cache)) != -1) {
			
				fOut.write(cache, 0, index);
			}
		}
		return true;
	}
	
	public static List<String> getImageFileNames() throws IOException {
		Path filePath = Paths.get(getImagePath());
		List<String> fileNameList =
				Files.list(filePath).map(p->p.getFileName().toString()).
				collect(Collectors.toList());
		return fileNameList;
	}
	
	public static void main(String[] args) throws IOException {
		ImageTools.setImagePath("c:\\upload_images");
//		FileInputStream fin = new FileInputStream("C:\\Users\\xvpow\\OneDrive\\Desktop\\upload\\check.png");
//		ImageTools.uploadFile(fin, "check.png");
//		System.out.println("Save!");
		System.out.println(ImageTools.getImageFileNames());
	}
}
