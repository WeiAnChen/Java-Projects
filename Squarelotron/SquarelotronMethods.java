/**
 * 
 */
package Squarelotron;

/**
 * @author MunkoChiu & Wei-An Chen
 *
 */
public interface SquarelotronMethods {
	public class Squarelotron {
        // instance variables
        public int[][] squarelotron;
        public int size;
        
        // constructors
        public Squarelotron(int n){
            this.size = n;
            //use size:n to determine the squarelotron
            int[][] myDoubleArray = new int[n][n];
            
            int count = 0;
            for (int i=0;i<n;i++){
                for (int j=0;j<n;j++){
                    count += 1;
                    myDoubleArray[i][j]=count;
                    //System.out.println(myDoubleArray[i][j]);
                }
            }
            
            this.squarelotron = myDoubleArray;
            
        }
        
        public Squarelotron(int[] array){
            double root = Math.sqrt(array.length);
            int intRoot = (int)root;
            this.size = intRoot;
            
            int[][] mySecondArray = new int[intRoot][intRoot]; 
            int arrayIndex = 0;
            
            for (int k=0;k<intRoot;k++){
                for (int m=0;m<intRoot;m++){
                    mySecondArray[k][m]= array[arrayIndex];
                    arrayIndex += 1;
                }
            }
            
            this.squarelotron = mySecondArray;
        }
        
        // Methods begin
        public static Squarelotron makeSquarelotron(int[] array){
            
            double root2 = Math.sqrt(array.length);
            int intRoot2 = (int)root2;
            
            // check errors
            if ((root2-intRoot2)==0){
                for (int h=0;h<array.length;h++){
                    if (array[h]<0 || array[h]>99){
                        throw new IllegalArgumentException("bad array provided");
                    }
                }
                Squarelotron mySquarelotron = new Squarelotron(array);
                return mySquarelotron;
                
            }
            else{
                throw new IllegalArgumentException("bad array provided");
            }
            
        }

        public int[] numbers(){
            
            int[] numArray = new int[this.size*this.size];
            int count2 = 0;
            
            for (int x=0;x<this.size;x++){
                for (int y=0;y<this.size;y++){
                
                numArray[count2]=this.squarelotron[x][y];
                count2 += 1;
                }
            }
             
            return numArray;
        }
        
        public Squarelotron upsideDownFlip(int ring){
            /**
             * Return a new squarelotron with updown flip
             *  the original one should not change.
             */
            Squarelotron upDownSquare = new Squarelotron(this.size);
            
            for (int i=0; i<this.size;i++){
                for (int j=0; j<this.size;j++){
                	upDownSquare.squarelotron[i][j] = this.squarelotron[i][j];
                }
            }
            
            
            int lower = ring - 1;
            int upper = this.size - ring;
            
            for (int i=lower; i<=upper; i++){
            	upDownSquare.squarelotron[lower][i] = this.squarelotron[upper][i];
            	upDownSquare.squarelotron[upper][i] = this.squarelotron[lower][i];
            }
            
            
        	int j = upper;
            for (int i = lower+1; i<=j; i++){
            	j -= 1;
            	upDownSquare.squarelotron[i][lower] = this.squarelotron[j][lower];
            	upDownSquare.squarelotron[j][lower] = this.squarelotron[i][lower];
            	upDownSquare.squarelotron[i][upper] = this.squarelotron[j][upper];
            	upDownSquare.squarelotron[j][upper] = this.squarelotron[i][upper];
            	
            }
            
            return upDownSquare;
            
          // Squarelotron upDownSquare = this.squarelotron;
            
        }
        
        public Squarelotron leftRightFlip(int ring){
            /**
             * This method performs the Left-Right Flip of the squarelotron, as described above, 
             * and returns the new squarelotron. 
             * The original should not be modified
             */
            
            Squarelotron LRSquare = new Squarelotron(this.size);
            
            for (int i=0; i<this.size;i++){
                for (int j=0; j<this.size;j++){
                	LRSquare.squarelotron[i][j] = this.squarelotron[i][j];
                }
            }
            
            
            int lower = ring - 1;
            int upper = this.size - ring;
            
            for (int i=lower; i<=upper; i++){
            	LRSquare.squarelotron[i][lower] = this.squarelotron[i][upper];
            	LRSquare.squarelotron[i][upper] = this.squarelotron[i][lower];
            }
            
            
            int j = upper;
            for (int i = lower+1; i<=j; i++){
            	j -= 1;
            	LRSquare.squarelotron[lower][i] = this.squarelotron[lower][j];
            	LRSquare.squarelotron[upper][i] = this.squarelotron[upper][j];
            	
            }
            
            
            return LRSquare;
            
        }
        
        
        public Squarelotron inverseDiagonalFlip(int ring){
            
            Squarelotron invDiaSquare = new Squarelotron(this.size);
            
            for (int i=0; i<this.size;i++){
                for (int j=0; j<this.size;j++){
                	invDiaSquare.squarelotron[i][j] = this.squarelotron[i][j];
                }
            }
            
            int lower = ring - 1;
            int upper = this.size - ring;
            
            for (int i=lower; i<=upper; i++){
            	invDiaSquare.squarelotron[lower][i] = this.squarelotron[this.size-i-1][upper];
            	invDiaSquare.squarelotron[invDiaSquare.size-i-1][upper] = this.squarelotron[lower][i];
            }
            
            for (int i=lower+1; i<=upper; i++){
            	invDiaSquare.squarelotron[i][lower] = this.squarelotron[upper][this.size-i-1];
            	invDiaSquare.squarelotron[upper][invDiaSquare.size-i-1] = this.squarelotron[i][lower];
            }
            
           
            return invDiaSquare;
        }
        
        public Squarelotron mainDiagonalFlip(int ring){
            
            Squarelotron mainDiaSquare = new Squarelotron(this.size);
            
            for (int i=0; i<this.size;i++){
                for (int j=0; j<this.size;j++){
                	mainDiaSquare.squarelotron[i][j] = this.squarelotron[i][j];
                }
            }
            
            int lower = ring - 1;
            int upper = this.size - ring;
            
            for (int i=lower; i<=upper; i++){
            	mainDiaSquare.squarelotron[lower][i] = this.squarelotron[i][lower];
            	mainDiaSquare.squarelotron[i][lower] = this.squarelotron[lower][i];
            }
            
            for (int i=lower+1; i<=upper; i++){
            	mainDiaSquare.squarelotron[i][upper] = this.squarelotron[upper][i];
            	mainDiaSquare.squarelotron[upper][i] = this.squarelotron[i][upper];
            }
            
           
            return mainDiaSquare;
        }
    
       /* public Squarelotron upsideDownFlip(int ring){
            
             //* Return a new squarelotron with updown flip
             //*  the original one should not change.
             
            
           Squarelotron upDownSquare = new Squarelotron(this.size);
            
            int central = this.size/2;
            int central2 = (int)Math.ceil(this.size/2.0);
            //System.out.println(central2);
            
            if (ring == central2){
                if(central<central2){
                    upDownSquare.squarelotron[central][central]=this.squarelotron[central][central];
                }
                else{
                    upDownSquare.squarelotron[central][central]=this.squarelotron[central-1][central];
                    upDownSquare.squarelotron[central-1][central-1]=this.squarelotron[central][central-1];
                    upDownSquare.squarelotron[central-1][central]=this.squarelotron[central][central];
                    upDownSquare.squarelotron[central][central-1]=this.squarelotron[central-1][central-1];
                }
            }
            else if (ring >central2 || ring<=0){
                throw new IllegalArgumentException("bad ring input");
            }
            
            else{
                for(int w=ring-1;w<=this.size-ring;w++){
                    upDownSquare.squarelotron[ring-1][w]=this.squarelotron[this.size-ring][w];
                    upDownSquare.squarelotron[this.size-ring][w]=this.squarelotron[ring-1][w];
                }
                for(int counter=ring;counter<this.size-ring;counter++){
                    upDownSquare.squarelotron[counter][ring-1]=this.squarelotron[this.size-counter-1][ring-1];
                    upDownSquare.squarelotron[counter][this.size-ring]=this.squarelotron[this.size-counter-1][this.size-ring];
                }

            }
            return upDownSquare;
            
        }
        
        public Squarelotron leftRightFlip(int ring){
            //
             //* This method performs the Left-Right Flip of the squarelotron, as described above, 
           //  * and returns the new squarelotron. 
            // * The original should not be modified
            // 
            
            Squarelotron LRSquare = new Squarelotron(this.size);
            
            int LRcentral = this.size/2;
            int LRcentral2 = (int)Math.ceil(this.size/2.0);
            
            if (ring == LRcentral2){ // The most central one. This should be the same as upDown.
                if(LRcentral<LRcentral2){ // odd size matrix Ex. 3*3, 5*5, 7*7 
                    LRSquare.squarelotron[LRcentral][LRcentral]=this.squarelotron[LRcentral][LRcentral];
                }
                else{
                    LRSquare.squarelotron[LRcentral][LRcentral]=this.squarelotron[LRcentral][LRcentral-1];
                    LRSquare.squarelotron[LRcentral-1][LRcentral-1]=this.squarelotron[LRcentral-1][LRcentral];
                    LRSquare.squarelotron[LRcentral-1][LRcentral]=this.squarelotron[LRcentral-1][LRcentral-1];
                    LRSquare.squarelotron[LRcentral][LRcentral-1]=this.squarelotron[LRcentral][LRcentral];
                }
            }
            else if (ring >LRcentral2 || ring <= 0){// The bad input situation. This should be the same as well.
                throw new IllegalArgumentException("bad ring input");
            }
            
            else{ // others
                
                // flip left-right columns:
                for (int d=ring-1; d<=this.size-ring; d++){
                    LRSquare.squarelotron[d][ring-1]=this.squarelotron[d][this.size-ring];
                    LRSquare.squarelotron[d][this.size-ring]=this.squarelotron[d][ring-1];
                }
                
                // flip the rest..
                for(int counter2=ring;counter2<this.size-ring;counter2++){
                    LRSquare.squarelotron[ring-1][counter2]=this.squarelotron[ring-1][this.size-counter2-1];
                    
                    LRSquare.squarelotron[this.size-ring][counter2]=this.squarelotron[this.size-ring][this.size-counter2-1];
                }
            }
            return LRSquare;
            
        }
        public Squarelotron inverseDiagonalFlip(int ring){
            
            Squarelotron invDiaSquare = new Squarelotron(this.size);
            int central = size/2;
            int central2 = (int)Math.ceil(size/2.0);
            
            if (ring == central2){ // The most central one. This should be the same as upDown.
                if(central<central2){ // odd size matrix Ex. 3*3, 5*5, 7*7 
                    invDiaSquare.squarelotron[central][central]=this.squarelotron[central][central];
                }
                else{// even size matrix Ex. 4*4, 6*6, 8*8
                    invDiaSquare.squarelotron[central][central]=this.squarelotron[central-1][central-1];
                    invDiaSquare.squarelotron[central-1][central-1]=this.squarelotron[central][central];
                    invDiaSquare.squarelotron[central-1][central]=this.squarelotron[central-1][central];
                    invDiaSquare.squarelotron[central][central-1]=this.squarelotron[central][central-1];
                }
            }
            else if (ring >central2 || ring <= 0){// The bad input situation. This should be the same as well.
                throw new IllegalArgumentException("bad ring input");
            }
            
            else{ // others
                
                for(int counter=ring;counter<=this.size-ring;counter++){
                    invDiaSquare.squarelotron[ring-1][counter-1]=this.squarelotron[this.size-counter][this.size-ring];
                    invDiaSquare.squarelotron[counter][ring-1]=this.squarelotron[this.size-ring][this.size-counter-1];
                    
                    invDiaSquare.squarelotron[this.size-counter][this.size-ring]=this.squarelotron[ring-1][counter-1];
                    invDiaSquare.squarelotron[this.size-ring][this.size-counter-1]=this.squarelotron[counter][ring-1];
                    
                }
            }
            return invDiaSquare;
        }
        
        public Squarelotron mainDiagonalFlip(int ring){
            
            Squarelotron mainDiaSquare = new Squarelotron(this.size);
            int central = size/2;
            int central2 = (int)Math.ceil(size/2.0);
            
            if (ring == central2){ // The most central one. This should be the same as upDown.
                if(central<central2){ // odd size matrix Ex. 3*3, 5*5, 7*7 
                    mainDiaSquare.squarelotron[central][central]=this.squarelotron[central][central];
                }
                else{// even size matrix Ex. 4*4, 6*6, 8*8
                    mainDiaSquare.squarelotron[central][central]=this.squarelotron[central][central];
                    mainDiaSquare.squarelotron[central-1][central-1]=this.squarelotron[central-1][central-1];
                    mainDiaSquare.squarelotron[central-1][central]=this.squarelotron[central][central-1];
                    mainDiaSquare.squarelotron[central][central-1]=this.squarelotron[central-1][central];
                }
            }
            else if (ring >central2 || ring <= 0){// The bad input situation. This should be the same as well.
                throw new IllegalArgumentException("bad ring input");
            }
            
            else{ // others
                
                for(int counter=ring;counter<=this.size-ring;counter++){
                    mainDiaSquare.squarelotron[ring-1][counter]=this.squarelotron[counter][ring-1];
                    mainDiaSquare.squarelotron[counter][this.size-ring]=this.squarelotron[this.size-ring][counter];
                    
                    mainDiaSquare.squarelotron[counter][ring-1]=this.squarelotron[ring-1][counter];
                    mainDiaSquare.squarelotron[this.size-ring][counter]=this.squarelotron[counter][this.size-ring];
                }
            }
            
            return mainDiaSquare;
        }*/
        
        
        //Flip the two most left/right/top/bottom rows/columns.
        public Squarelotron sideFlip(String side){
            Squarelotron sideFlipSquare = new Squarelotron(this.size);

            for (int i=0; i<this.size;i++){
                for (int j=0; j<this.size;j++){
                    sideFlipSquare.squarelotron[i][j] = this.squarelotron[i][j];
                }
            }

            if(side == "left"){
                for(int i=0; i<sideFlipSquare.size; i++){
                    sideFlipSquare.squarelotron[i][0] = this.squarelotron[i][1];
                    sideFlipSquare.squarelotron[i][1] = this.squarelotron[i][0];
                    
                }
            }
            else if(side =="right"){
                for(int i=0; i<sideFlipSquare.size; i++){
                    sideFlipSquare.squarelotron[i][sideFlipSquare.size-1] = this.squarelotron[i][this.size-2];
                    sideFlipSquare.squarelotron[i][sideFlipSquare.size-2] = this.squarelotron[i][this.size-1];
                  
                }
	          }
            else if(side =="top"){
                for(int i=0; i<sideFlipSquare.size; i++){
                    sideFlipSquare.squarelotron[0][i] = this.squarelotron[1][i];
                    sideFlipSquare.squarelotron[1][i] = this.squarelotron[0][i];
                    
                }
            }
            else if(side == "bottom"){
                for(int i=0; i<sideFlipSquare.size; i++){
                    sideFlipSquare.squarelotron[sideFlipSquare.size-1][i] = this.squarelotron[this.size-2][i];
                    sideFlipSquare.squarelotron[sideFlipSquare.size-2][i] = this.squarelotron[this.size-1][i];
                   
                }
            }
            else {
                System.out.println("Invalid input for 'String side'. ");
            }

            return sideFlipSquare;
        }

        //I create a method that rotate once, then call it in the following methods ratateRight.
        public void rorateRightOnce(){
            Squarelotron rotateRightOnceSquare = new Squarelotron(this.size);

            for (int i=0; i<this.size;i++){
                for (int j=0; j<this.size;j++){
                    rotateRightOnceSquare.squarelotron[i][j] = this.squarelotron[i][j];
                }
            }


            for (int i=0; i<this.size; i++){
                for(int j=0; j<this.size; j++){
                    rotateRightOnceSquare.squarelotron[j][this.size-i-1] = this.squarelotron[i][j];
                }
            }

            this.squarelotron = rotateRightOnceSquare.squarelotron;

        }


        //I use switch statement to run the method of rotateRight.
        public void rorateRight(int numberOfTurns){
        	
            //rotate every 4 times, it go the same as the initial form.
            //So, I calculate out the modulus of the # of rotation, then rotate in 4 cases.
            int reminder = numberOfTurns % 4;

            //If it rotate left, which can be seen as rotate right for negative times, take the modulus by 4,
            //the # of left rotations equals to 4+# right rotations.
            if(reminder < 0){
                reminder = 4 + reminder;
            }

            switch(reminder){
            case 0:
                System.out.println("Rotate for " + numberOfTurns + " times.");
                break;
            case 1:
                rorateRightOnce();
                System.out.println("Rotate for " + numberOfTurns + " times.");
                break;
            case 2:
                rorateRightOnce();
                rorateRightOnce();
                System.out.println("Rotate for " + numberOfTurns + " times.");
                break;
            case 3:
                rorateRightOnce();
                rorateRightOnce();
                rorateRightOnce();
                System.out.println("Rotate for " + numberOfTurns + " times.");
                break;
            default :
                System.out.println("Invalid input for 'numberOfTurns'. ");
                break;
            }
        }


        
        @Override 
        public boolean equals(Object object){
            /**
             * This method returns boolean about the object is a squarelotron
             * to "this" squarelotron.
             * If it is, then returns true and false otherwise.
             * Squarelotrons are considered equal if they encounterd rotation mathod
             * Squarelotrons with different size are never equal.
             * 
             */
            

            Squarelotron checkObject = (Squarelotron) object; 

            boolean equalSize = false;
            //boolean sameClass = false; //Since TA told my partner that it is assume that object.squarelotron is of type int[][], I skip it.
            boolean sameElement = false;
            
            //Check the equality of size.
            if (checkObject.size == this.size){
                equalSize = true;
            }
            else{
                equalSize = false;
            }
            
            //Check every element in both squarelotron is the same. And count the # of them.
            int count = 0;
            int compareSize;
            if (checkObject.size <= this.size){
                compareSize = checkObject.size;
            }
            else {
                compareSize = this.size;
            }
            for (int f=0; f<compareSize;f++){
                for (int g=0;g<compareSize;g++){
                    if (checkObject.squarelotron[f][g]==this.squarelotron[f][g]){
                        // This if statement will include rotate situation.
                        count++;
                    }   
                }
            }

            //If 'count' equals the size*size, it means the two squarelotron are uniform.
            if (count==this.size*this.size){
                sameElement = true;
            }
            else{
                sameElement = false;
            }

            //only return true, if both size and element are the same.
            return (equalSize && sameElement);
        }
        
        
        @Override public String toString(){
            /**
             * This method will return a printable form of String 
             * of this squarelotron. (which is a 2D array)
             * The return string should contain newline characters
             * between rows. 
             */
            String totalList = "";
            
            for (int p=0;p<this.squarelotron.length;p++){
                for (int q=0;q<this.squarelotron.length;q++){
                    int elementInt = this.squarelotron[p][q];
                    String element = Integer.toString(elementInt);
                    totalList += element;
                    totalList += "\t"; 
                }
                totalList += "\n";
            }
            
            return totalList;
            
        }
        
        public static void main(String[] args) {
            
            int[] myArray = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25}; 
            int[] myArrai = {4,5,6,7,8,11,60,70,80,2,1,15,16,17,18,19,25,35,45,75,95,33,34,64,67};
            
             
            
            Squarelotron testSquare = Squarelotron.makeSquarelotron(myArray);
            Squarelotron testSquare2 = new Squarelotron(5); 
            Squarelotron testSquare3 = new Squarelotron(myArrai);
            Squarelotron testSize = new Squarelotron(4);
            
            
            Squarelotron upDown = testSquare2.upsideDownFlip(1);
            Squarelotron leftRight = testSquare2.leftRightFlip(3);
            Squarelotron InvD = testSquare2.inverseDiagonalFlip(3);
            Squarelotron mainD = testSquare2.mainDiagonalFlip(3);
            
            int[] testNumbers = upDown.numbers();
            
            //Squarelotron leftRight = testSquare.leftRightFlip(1);
            //Squarelotron InvD = testSquare.inverseDiagonalFlip(1);
            //Squarelotron mainD = testSquare.mainDiagonalFlip(1);
            boolean nottheSame = testSquare.equals(InvD);
            boolean theSame = testSquare.equals(testSquare2);
            boolean nottheSame2 = testSquare.equals(testSquare3);
            boolean sizeTest = testSquare.equals(testSize);
            
            for (int t=0; t<testNumbers.length; t++){
                System.out.print(testNumbers[t]);
                System.out.print(",");
            }
            int[] checking1Array = {21,22,23,24,25,16,7,8,9,20,11,12,13,14,15,6,17,18,19,10,1,2,3,4,5};
            System.out.println("\n");
            /*
            for (int s=0; s<testNumbers.length; s++){
                System.out.print(testNumbers[s]);
                System.out.print(" ");
            }
            */
            
           
            
        }
        
    }
	
	/*public int[] numbers();
	public Squarelotron upsideDownFlip(int ring);
	public Squarelotron leftRightFlip(int ring);
	public Squarelotron inverseDiagonalFlip(int ring);
	public Squarelotron mainDiagonalFlip(int ring);
	public Squarelotron sideFlip(String side);
	public void rotateRight(int numberOfTurns);
	@Override public boolean equals(Object object);
	@Override public String toString();*/

}
