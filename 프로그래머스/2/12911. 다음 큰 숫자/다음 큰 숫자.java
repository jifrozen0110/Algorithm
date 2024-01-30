class Solution {
    public int solution(int n) {
        String binaryNumber=Integer.toBinaryString(n);
        
        int oneCount=countOne(binaryNumber);
        
        n=n+1;
        while(true){
            String bigBinaryNumber=Integer.toBinaryString(n);
            int tempCount=countOne(bigBinaryNumber);
            if(isSame(oneCount,tempCount)){
                break;
            }
            n++;
        }
        return n;
    }
    public boolean isSame(int a,int b){
        if(a==b){
            return true;
        }
        return false;
    }
    public int countOne(String num){
        int count=0;
        for(char c:num.toCharArray()){
            if(c=='1'){
                count++;
            }
        }
        
        return count;
    }
}