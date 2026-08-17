class Solution {
    public boolean isValidSudoku(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        for(int i=0; i<row; i++){
        	int[] set = new int[10];
        	for(int j=0; j<col; j++){
        		if(board[i][j] == '.') continue;

        		int num = board[i][j] - '0';
        		if(set[num] != 0) return false;

        		set[num] = 1;

        	}
        }

        for(int i=0; i<col; i++){
        	int[] set = new int[10];
        	for(int j=0; j<row; j++){
        		if(board[j][i] == '.') continue;

        		int num = board[j][i] - '0';
        		if(set[num] != 0) return false;

        		set[num] = 1;

        	}
        }

        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();

        for(int i=0; i<=6; i+=3){
        	for(int j=0; j<=6; j+=3){
        		ArrayList<Integer> temp = new ArrayList<>();
        		temp.add(i);
        		temp.add(j);	
        		arr.add(temp);
        	}
        }

        for(ArrayList<Integer> point : arr){
        	int i = point.get(0);
        	int j = point.get(1);
        	HashSet<Integer> set = new HashSet<>();
        	for(int k=0; k<3; k++){
        		for(int l=0; l<3; l++){
        			int r1 = i + k;
        			int c1 = j + l;
        			if(board[r1][c1] == '.') continue;
        			if(set.contains(board[r1][c1]-'0')) return false;

        			set.add(board[r1][c1] - '0');
        		}
        	}
        }

        return true;
    }
}