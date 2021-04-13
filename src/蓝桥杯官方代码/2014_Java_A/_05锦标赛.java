/*
标题：锦标赛

   如果要在n个数据中挑选出第一大和第二大的数据（要求输出数据所在位置和值），使用什么方法比较的次数最少？我们可以从体育锦标赛中受到启发。

   如图【1.png】所示，8个选手的锦标赛，先两两捉对比拼，淘汰一半。优胜者再两两比拼...直到决出第一名。

   第一名输出后，只要对黄色标示的位置重新比赛即可。

   下面的代码实现了这个算法(假设数据中没有相同值)。

   代码中需要用一个数组来表示图中的树（注意，这是个满二叉树, 不足需要补齐）。它不是存储数据本身，而是存储了数据的下标。

   第一个数据输出后，它所在的位置被标识为-1

class A{
   	//a 表示待处理的数据，长度如果不是2的次幂，则不足位置补为-1
	static void pick(int[] a)
	{
		int n = 1;
		while(n<a.length) n *= 2;


		int[] b = new int[2*n-1];
		for(int i=0; i<n; i++){
			if(i<a.length)
				b[n-1+i] = i;
			else
				b[n-1+i] = -1;
		}

		//从最后一个向前处理
		for(int i=b.length-1; i>0; i-=2){
			if(b[i]<0){
				if(b[i-1]>=0)
					b[(i-1)/2] = b[i-1];
				else
					b[(i-1)/2] = -1;
			}
			else{
				if(a[b[i]]>a[b[i-1]])
					b[(i-1)/2] = b[i];
				else
					b[(i-1)/2] = b[i-1];
			}
		}

		//输出树根
		System.out.println(b[0] + ": " + a[b[0]]);

		//值等于根元素的位置需要重新pk
		pk(a,b,0,b[0]);

		//再次输出树根
		System.out.println(b[0] + ": " + a[b[0]]);
	}

	// a 表示待处理数据，b 二叉树，k 当前要重新比拼的位置，v 已经决胜出的值
   	static void pk(int[] a, int[] b, int k, int v)
	{

		int k1 = k*2+1;
		int k2 = k1 + 1;

		if(k1>=b.length || k2>=b.length){
			b[k] = -1;
			return;
		}

		if(b[k1]==v)
			pk(a,b,k1,v);
		else
			pk(a,b,k2,v);


		//重新比较
		if(b[k1]<0){
			if(b[k2]>=0)
				b[k] = b[k2];
			else
				b[k] = -1;
			return;
		}

		if(b[k2]<0){
			if(b[k1]>=0)
				b[k] = b[k1];
			else
				b[k] = -1;
			return;
		}

		if(__________________________)  //填空
			b[k] = b[k1];
		else
			b[k] = b[k2];
	}
}


    请仔细分析流程，填写缺失的代码。

    通过浏览器提交答案，只填写缺失的代码，不要填写已有代码或其它说明语句等。



*/
public class _05锦标赛 {
  public static void main(String[] args) {
    int a[] = {154,55,18,16,122,17,130,9,58};//原始数据
    A.pick(a);
  }
}
class A{
  //a 表示待处理的数据，长度如果不是2的次幂，则不足位置补为-1
  static void pick(int[] a)
  {
    int n = 1;
    while(n<a.length) n *= 2;


    int[] b = new int[2*n-1];
    for(int i=0; i<n; i++){
      if(i<a.length)
        b[n-1+i] = i;
      else
        b[n-1+i] = -1;
    }

    //从最后一个向前处理
    for(int i=b.length-1; i>0; i-=2){
      if(b[i]<0){
        if(b[i-1]>=0)
          b[(i-1)/2] = b[i-1];
        else
          b[(i-1)/2] = -1;
      }
      else{
        if(a[b[i]]>a[b[i-1]])
          b[(i-1)/2] = b[i];
        else
          b[(i-1)/2] = b[i-1];
      }
    }

    //输出树根
    System.out.println(b[0] + ": " + a[b[0]]);

    //值等于根元素的位置需要重新pk
    pk(a,b,0,b[0]);

    //再次输出树根
    System.out.println(b[0] + ": " + a[b[0]]);
  }

  // a 表示待处理数据，b 二叉树，k 当前要重新比拼的位置，v 已经决胜出的值
  static void pk(int[] a, int[] b, int k, int v)
  {

    int k1 = k*2+1;
    int k2 = k1 + 1;

    if(k1>=b.length || k2>=b.length){
      b[k] = -1;
      return;
    }

    if(b[k1]==v)
      pk(a,b,k1,v);
    else
      pk(a,b,k2,v);


    //重新比较
    if(b[k1]<0){
      if(b[k2]>=0)
        b[k] = b[k2];
      else
        b[k] = -1;
      return;
    }

    if(b[k2]<0){
      if(b[k1]>=0)
        b[k] = b[k1];
      else
        b[k] = -1;
      return;
    }

    if(a[b[k1]]>a[b[k2]])  //填空
      b[k] = b[k1];
    else
      b[k] = b[k2];
  }
}