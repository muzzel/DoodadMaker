import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;

public class DoodadMaker {
	
	public void run(String importPath, String outputFile, boolean recoursive) throws IOException {
		File in = new File("imports", importPath);
		LinkedList<ModelFile> modelFiles = listFilesForFolder(in, recoursive);
		genWurstCode(modelFiles, outputFile);
	}
	
	private LinkedList<ModelFile> listFilesForFolder(final File folder, boolean recoursive) {
		LinkedList<ModelFile> modelFiles = new LinkedList<ModelFile>();
	    for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory() && recoursive) {
	            modelFiles.addAll(listFilesForFolder(fileEntry, recoursive));
	        } else {
	        	if (fileEntry.getName().toLowerCase().endsWith(".mdx")) {
	        		modelFiles.add(new ModelFile(fileEntry.getPath(), fileEntry.getName()));
	        	}
	        }
	    }
	    return modelFiles;
	}
	
	private void genWurstCode(LinkedList<ModelFile> modelFiles, String outputFile) throws IOException {
		FileWriter fw = new FileWriter(outputFile + ".wurst");
		// File header:
		 fw.write("package " + outputFile + "\n");
		 fw.write("import DoodadMaker\n\n");
		 fw.write("@compiletime function genDoodads()\n");
		 
		for (ModelFile mf : modelFiles) {
			fw.write("\t" + mf.toWurstCode() + "\n");
		}
		fw.close();
	}
}
