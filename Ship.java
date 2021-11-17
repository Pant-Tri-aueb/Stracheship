public class Ship {
	public void RIGHT(C[][],x1,y1,x2,y2) {
	boolean bam=false;
		if (x1<x2) {
			for (x1;x1<=x2;x1++) {
				if (C[x1][y1+1]="S" || (y1+1>10) ) {
					bam= true;
				}
			}
			if bam=false {
				for (x1;x1<=x2;x1++) {
					C[x1][y1]=C[x1][y1+1];
				}
			}else {
				System.out.println("αλλου αυτα");
			}
		}else {
			if (C[x2][y2+1]="S" || (y2+1>10)) {
				bam=true;
			}
			if(bam=false) {
			for(y2;y1<=y2;y2) {
				C[x1][y2]=C[x1][y2+1];
			}
			}else {
				System.out.println("αλλου αυτα");
			}
		}
	}
	
	
	public void LEFT(C[][],x1,y1,x2,y2) {
		if (x1<x2) {
			for (x1;x1<=x2;x1++) {
				C[x1][y1]=C[x1][y1-1];
			}
		}else {
			for(y1;y1<=y2;y1++) {
				C[x1][y1]=C[x1][y1-1];
			}
	}
}
	
	
	public void UP(C[][],x1,y1,x2,y2) {
		if(x1<x2) {
			for(x2;x1<=x2;x2--) {
				C[x1][y1]=C[x1+1][y1];
		}else {
			for(x1;x1<=x2;x1++) {
				C[x1][y1]=C[x1+1][y1];
			}
		}
		}
	}
	
	public void DOWN(C[][],x1,y1,x2,y2) {
		if(x1<x2) {
			for(x1;x1<=x2;x1++) {
				C[x1][y1]=C[x1-1][y1];
		}else {
			for(x1;x1<=x2;x1++) {
				C[x1][y1]=C[x1-1][y1];
			}
		}
		}
	}




	

