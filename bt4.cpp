#include<stdio.h>
#include<conio.h>
int tongbac3(int n)
{
int S=0;
 for(int i=0;i<=n;i++)
   {
    S= S + (i*i*i); 
   }
return S;
}
int main()
{
int n;
int a,b=0;
printf("nhap vao so n: ");
scanf("%d",&n);
printf("tong bac 3 la : %d ",tongbac3(n));
}
