import java.io.File; 
import java.util.Scanner;
import java.io.FileNotFoundException; 
// import java.util.NoSuchElementException;

	
	public class UtepTube{
	public static void main(String[] args) throws FileNotFoundException{

	Scanner scanner = new Scanner(System.in);

	File csv = new File("/Users/andri/OneDrive/Desktop/cs1/UtepTube/corpus.csv");


		String options = ("Welcome to UtepTube! Please select an option below to continue:\n" +
				"\t1. List videos in corpus\n" +
				"\t2. Add video to playlist\n" +
				"\t3. View playlist\n" +
				"\t4. Clear playlist\n" +
				"\t5. Close UtepTube");

		System.out.println(options);
		int input = scanner.nextInt();
		boolean menu = true;
		String playlist = "";
		String playlistR = "";
		int option3 = 0;
		String minute2=" ";
		String seconds2=" ";
		int hours3 = 00;
		int minute3= 00;
		int seconds3= 00;
		// boolean one = true;

		while(menu){
			//after each choice, go back here to reset.
			if (input > 5){
				input = 0;
				System.out.println(options);
				input = scanner.nextInt();

			}
			// Display corpus
			if (input == 1){

				System.out.println("+-----------------------------------------------------------------------------------------------+" +
  				"\n|" + "\t\t\t\t\tUtepTube Corpus\t\t\t\t\t\t" + "|" + 
  				"\n+-------------+---------------------------------------------------+---------------------+-------+");
  				// try{
  				Scanner file = new Scanner(csv);
  				file.useDelimiter(",|\n");
  				while (file.hasNextLine()){

  					// String idLine = csvC.nextLine();
					// Scanner file = new Scanner(idLine);
  					// file.useDelimiter(",");
  					// corpus content
		  			String id = file.next();
		  			String title = file.next();
		  			String creator = file.next();
		  			String minute = file.next();
		  			String seconds = file.next();
		  			String preRoll = file.next();
		  			String midRoll = file.next();
		  			String postRoll = file.next();
		  			System.out.println("| " + id + " " + "| " + title + " " + "|" + " " + creator + " |" + " " +  minute + ":" + seconds + " " + "|");
		  			System.out.println("+-------------+---------------------------------------------------+---------------------+-------+");		  				  			
		  		}
		  		//input + 999 allows program to display options again
		  		input+=999;				
				// }catch (FileNotFoundException e){

				// }

			}
			// adding video to playlist
			if (input == 2){

				String id2=" ";
				String title2=" ";
				String creator2=" ";
		
				String preRoll2=" ";
				String midRoll2=" ";
				String postRoll2=" ";
				String noAds = " ";
				// String playlist = " ";
				// String playlistR = " ";
				// user input
				System.out.println("Input Video ID: ");
				Scanner two = new Scanner(csv);
				String idChoice = scanner.next();
				
				// reads file again; same as first option
				String idLine = two.nextLine();
				Scanner file = new Scanner(idLine);
				// Scanner file = new Scanner(csv);
				// comma delimiter
				file.useDelimiter(",");
				boolean isInside = false;
				
  				while (isInside == false && two.hasNextLine()){
  				// while(two.hasNextLine){
  				// while(false){
  					// String idLine = csvC.nextLine();
					// Scanner file = new Scanner(idLine);
  					// file.useDelimiter(",");
  					idLine = two.nextLine();
  					file = new Scanner(idLine);
  					file.useDelimiter(",");
  					id2 = file.next();

  					if(idChoice.equals(id2)){
  						isInside = true;  						
  					}
  				}
				if(isInside){
					
					title2 = file.next();
					creator2 = file.next();
					minute2=file.next();
					seconds2=file.next();
					preRoll2=file.next();
					midRoll2=file.next();
					postRoll2=file.next();
					
  					System.out.println(title2 + "\n by " +
  					creator2 + " has been added to your playlist");

  				}else{
  					System.out.println("VIDEO NOT FOUND! Please try again.");
  				}
  				if (preRoll2.equals("false") && midRoll2.equals("false") && postRoll2.equals("false")){
  					postRoll2 = "";
  					midRoll2 = "no ads";
  					preRoll2 = "";
  					// System.out.println("IM HERE");
  				}
  				//preroll code
  				if (preRoll2.equals("true")){
  					preRoll2 = "+30s preroll";
  				
  				}else if(preRoll2.equals("false")){
  					preRoll2 = "";
  				}
  				//midroll
  				if (midRoll2.equals("true")){
  					System.out.println("Do you want to skip the Mid-Roll ad? Yes or No.");
  					String ads = scanner.next();
  					if(ads.equalsIgnoreCase("Yes")){
  						midRoll2 = "+10s midroll";
  					}else if(ads.equalsIgnoreCase("No")){
  						midRoll2 = "+2m midroll";
  					}
  				}else if(midRoll2.equals("false")){
  					midRoll2 = "";
  				}
  				//postroll
  				if (postRoll2.equals("true")){
  					postRoll2 = "+5s postroll";
  				}else if(postRoll2.equals("false")){
  					postRoll2 = "";
  				}
  				
  				playlist = "https://youtu.be/" + id2 + " | " + minute2 + ":" + seconds2 + 
  					" ( " + preRoll2 + " " + midRoll2 + " " + postRoll2 + ")";
  				option3 ++;
  				// playlistR =  playlistR + " " + option3 + ". " + playlist + "\n";
  				// input+=999;
  				if (option3 < 10){
  					playlistR =  playlistR + " " + option3 + ". " + playlist + "\n";
  				}else{
  					playlistR = playlistR + option3 + ". " + playlist + "\n";
  				}
  				input+=999;
  				minute3 += Integer.parseInt(minute2)	;
				seconds3 += Integer.parseInt(seconds2);
  			}
  			// Display playlist including time
			if (input == 3){
				System.out.println("------------- YOUR PLAYLIST ------------"); 
				// System.out.println(option3);
				// System.out.println("\n");
				System.out.println(playlistR);
				// minute3 += Integer.parseInt(minute2)	;
				// seconds3 += Integer.parseInt(seconds2);
				if(minute3>=60){
					minute3-=60;
					hours3+=1;
					
				}
					// System.out.println("hello");
				if(seconds3>=60){
					seconds3-=60;
					minute3+=1;	
				}
				if (seconds3 > 10 && minute3 < 10){
					System.out.println("Total Time: " + "0" + hours3 + ":" + " " + minute3 +":" + seconds3);
				}
				if (seconds3 < 10 && minute3 > 10){
					System.out.println("Total Time: " + "0" + hours3 + ":" + minute3 +":"+ "0" + seconds3);
				}
				if (seconds3 < 10 && minute3 < 10){
					System.out.println("Total Time: " + "0" + hours3 + ":" + "0"+ minute3 +":"+ "0" + seconds3);
				}
				if (seconds3 > 10 && minute3 > 10){
					System.out.println("Total Time: " + "0" + hours3 + ":" + minute3 +":"+ seconds3);					
				}
			
				input+=999;
			}

			if (input == 4){
				// Ask user whether they want to delete or not.
				System.out.println("Do you want to delete your playlist? Yes or No?");
				String delete = scanner.next();
				if(delete.equalsIgnoreCase("Yes")){
					minute3 = 0;
					seconds3 = 0;
					option3 = 0;
					hours3 = 0;
					playlistR = " ";
					input+=999;
				}
				if(delete.equalsIgnoreCase("No")){
					input+=999;
				}
				// if (delete.equalsIgnoreCase(!"No")&&!delete.equalsIgnoreCase(!"Yes")) {
				// 	System.out.println("Invalid input. Please choose Yes or No.");
				// }
				if (!delete.equalsIgnoreCase("No")&&!delete.equalsIgnoreCase("Yes")) {
					System.out.println("Invalid input. Please choose Yes or No.");
				}
				
			}
			if (input == 5){
				System.out.println("See you next time!");
				menu = false;
		
				
			}

		}
	

	// }catch(FileNotFoundException e){

	// }

}
}
