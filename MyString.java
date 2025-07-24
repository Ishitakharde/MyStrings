import java.util.Arrays;

class MyStringIndexOutOfBoundsException extends RuntimeException{
	public MyStringIndexOutOfBoundsException(String message){
		super(message);
	}
}
final class MyString{
	char[]arr;
	public MyString(){
		arr=new char[0];
	}
	public MyString(String str){
		arr=new char[str.length()];
		for(int i=0;i<arr.length;i++){
			arr[i]=str.charAt(i);
		}
	}
	public MyString(StringBuffer sb){
		this(sb.toString());
	}
	public MyString(StringBuilder sb){
		this(sb.toString());
	}
	public MyString(char[]arr)
       {
       	this.arr=new char[arr.length];
       	for(int i=0;i<arr.length;i++)
       		this.arr[i]=arr[i];
       }
	public MyString(char[] array, int start, int count) {
	    if (start < 0 || count < 0 || (start + count) > array.length) {
	        throw new MyStringIndexOutOfBoundsException("INVALID [" + start + "," + start + "+" + count + "] out of bounds for length " + array.length);
	    }
	    this.arr = new char[count];
	    for (int i = 0, j = start; i < count; i++, j++) {
	        this.arr[i] = array[j];
	    }
	}
	//methods of string
@Override
      public String toString() {
       return new String(arr);
        }

       	
       public int length(){
       	return arr.length;
       }

       public boolean isEmpty(){
       	return arr.length==0;
       }

       public char charAt(int indx){
       	if(indx<0||indx>=arr.length){
       		throw new MyStringIndexOutOfBoundsException("Index"+indx+"out of bounds for length"+arr.length);
       	}
       		return arr[indx];
       	}

       
       public char codePointAt(int indx) {
    	    if (indx < 0 || indx >= arr.length) {
    	        throw new MyStringIndexOutOfBoundsException("Index " + indx + " out of bounds for length " + arr.length);
    	    }
    	    return arr[indx];
    	}

       public int codePointBefore(int indx){
       	return codePointAt(indx-1);
       }

       public int codePointCount(int start, int end) {
    	    if (start > end || start < 0 || end > arr.length) {
    	        throw new IndexOutOfBoundsException("Range [" + start + "," + end + "] out of bounds for length " + arr.length);
    	    }
    	    return end - start;
    	}
       

       
       public MyString toUpperCase(){
       	char[]newArr= new char[arr.length];
       	for(int i=0;i<arr.length;i++){
       		char ch =arr[i];
       		newArr[i]=(ch>=97&&ch<=122)?(char)(ch-32):ch;

       	}
       	return new MyString(newArr);
       }

        public MyString toLowerCase(){
       	char[]newArr= new char[arr.length];
       	for(int i=0;i<arr.length;i++){
       		char ch =arr[i];
       		newArr[i]=(ch>=65&&ch<=90)?(char)(ch+32):ch;

       	}
       	return new MyString(newArr);
       }

       	public int indexOf(int ascii,int start){
       		for(int i=start;i<arr.length;i++){
       			if(ascii==arr[i])return i;
       		}
       		return -1;
       	}

       	public int indexOf(int ascii){
       		return indexOf(ascii,0);
       	}
       
public MyString concat(MyString merge) {
	char[]newArr=new char[arr.length+merge.length()];
	int indx=0;
	for(char ele:arr)
		newArr[indx++]=ele;
	for(int i=0;i<merge.length();i++)
		newArr[indx++]=merge.charAt(i);
	return new MyString(newArr);
	
}
public boolean startsWith(MyString prefix,int start) {
	if(arr.length<prefix.length()||prefix.length()>=arr.length-start)return false;
	for(int i=0;i<prefix.length();i++)
		if(arr[start++]!=prefix.charAt(i))return false;
	return true;
}
public boolean startsWith(MyString prefix) {
	return startsWith(prefix,0);
}
public boolean endsWith(MyString suffix) {
	if(arr.length<suffix.length())return false;
	for(int i=suffix.length()-1,j=arr.length-1;i>=0;i--,j--)
		if(arr[j]!=suffix.charAt(i))return false;
	return true;
}

  public boolean equals(Object obj) {
	if(!(obj instanceof MyString))return false;
	MyString str=(MyString)obj;
	if(arr.length!=str.length())return false;
	for(int i=0;i<str.length();i++) 
		if(arr[i]!=str.charAt(i))return false;
		return true;
	}
public boolean contentEquals(StringBuffer sb) {
	MyString obj=new MyString (sb);
	return this.equals(obj);
}
public boolean equalsIgnoreCase(MyString str) {
	return this.toLowerCase().equals(str.toLowerCase());
}
public MyString replace(char oldChar, char newChar) {
	char[]newArr=arr.clone();
	for(int i=0;i<arr.length;i++)
		if(newArr[i]==oldChar)
			newArr[i]=newChar;
	return new MyString(newArr);
}
public MyString substring(int start, int end) {
	if((start>end)||start<0||end<0||end>arr.length)
throw new MyStringIndexOutOfBoundsException("Range [" + start + "," + end + "] out of bounds for length " + arr.length);
char[]newArr=new char[end - start];
for(int i=0;i<newArr.length;i++)
	newArr[i]=arr[start++];
	return new MyString(newArr);
}
public MyString substring(int offset) {
	if(offset==0)return new MyString(arr);
	return substring(offset,arr.length);
}
public MyString trim() {
	int left=0,right=0;
	for(int i=0;i<arr.length;i++) 
		if(arr[i]==' ')left++;
		else break;
		for(int i=arr.length-1;i>=0;i--) 
			if(arr[i]==' ')right++;
			else break;
			return substring(left,(arr.length)-right);
		}

        
       }
      class MyStringDriver71{
    		    public static void main(String[] args) {
    		        MyString str = new MyString("  hello java  ");
    		        System.out.println(str.toUpperCase());
    		        System.out.println(str.toLowerCase());
    		        System.out.println(str.indexOf('b'));
    		        System.out.println(str.codePointCount(1, 3));
    		        System.out.println(str.replace('a',(char)3));
    		        System.out.println(str.substring(7));
    		        System.out.println(str.trim());
    		    }
    		}


