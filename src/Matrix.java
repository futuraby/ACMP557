import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Matrix {
	
	public short[][] matr;
	public Matrix(short n) {
		this.matr= new short[n][n];
			} 
	public Matrix multiple(Matrix b,short n, short x,short sI,short sJ) {
		Matrix c = new Matrix(n);
		for(short m=0;m<n; m++) {
				for(short w=0;w<n;w++) {
						c.matr[sI][w]=(short) ((c.matr[sI][w]+this.matr[sI][m]*b.matr[m][w])%x);
						
				}
				for(short e=0;e<n;e++) {
						c.matr[sJ][e]=(short) ((c.matr[sJ][e]+this.matr[sJ][m]*b.matr[m][e])%x);
				}
		}
		return c;		
	}	
	public static void main(String[] args) throws IOException {
		FileWriter fw = new FileWriter("OUTPUT.TXT");
		FileReader fr = new FileReader("INPUT.TXT");		
		Scanner scan = new Scanner(fr); 
		short m =  scan.nextShort();
		short n = scan.nextShort();
		scan.nextLine();
		short searI=scan.nextShort();
		short searJ=scan.nextShort();
		searI--;
		searJ--;
		scan.nextLine();
		short p =scan.nextShort();
		scan.nextLine();
		Matrix a = new Matrix(n);
		Matrix b = new Matrix(n);
		for(short i =0;i<n;i++) {
			for(short j =0;j<n;j++) {
				a.matr[i][j]=scan.nextShort();
			}
			scan.nextLine();
		}
		for (short k =0;k<m-1;k++) {
            for(short i =0;i<n;i++) {
                for(short j =0;j<n;j++) {
                    b.matr[i][j]=scan.nextShort();
                }
            }
			scan.hasNextLine();
			a= a.multiple(b,n,p,searI,searJ);
			
		}
		fw.write(Short.toString(a.matr[searI][searJ]));
		scan.close();
		fr.close();
		fw.close();
	}
}
