import java.io.IOException;

public class Main {
	
	public static void main(String[] args) {
			if (args.length < 2) {
				System.out.println(help);
			} else {
				try {
					boolean rec = args.length >= 3 && args[2].equalsIgnoreCase("-r");
					new DoodadMaker().run(args[0], args[1], rec);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	}

	final static String help = "Usage: DoodadMaker pathToModels packageName [-r]"
			+ "\n pathToModels\t\t\tPath to folder containing the models,\n\t\t\t\t relative to the \"imports\" folder."
			+ "\n packagename\t\t\tPackageName of the generated wurst file."
			+ "\n -r\t\t\t\tRecoursive mode: also look in subfolders."
			+ "\nExample:"
			+ "\n DoodadMaker ForestDoodadPack GenForestDoodads -r"
			+ "\nwill look for model files in \\imports\\ForestDoodadPack\\ and generate GenForestDoodads.wurst";
}
