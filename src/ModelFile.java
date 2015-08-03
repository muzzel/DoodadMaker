
public class ModelFile {
	String pathRel;
	String fileName;
	
	public ModelFile(String pathRel, String fileName) {
		this.pathRel = pathRel;
		this.fileName = fileName;
	}
	
	public String toWurstCode() {
		return "genDoodad(\"" + fileName.substring(0, fileName.length()-4) + "\",\"" + pathRel.substring(8).replaceAll("\\\\", "\\\\\\\\").replaceAll(".mdx",  ".mdl") + "\")";
	}
}
