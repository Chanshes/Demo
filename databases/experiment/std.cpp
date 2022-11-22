#include<iostream>
#include<cmath>
#include<iomanip>
using namespace std;

//对称矩阵
void syma()
{
    while(1)
    {
        int n,a[1000];
    cin>>n;
    cout<<"请输入"<<n*(n+1)/2<<"个数:";
    for(int i=0;i<n*(n+1)/2;i++)
        cin>>a[i];
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            if(i>=j)
                cout<<setw(3)<<a[i*(i+1)/2+j]<<" ";
            else
                cout<<setw(3)<<a[j*(j+1)/2+i]<<" ";
        }
        cout<<endl;
    }
    cout<<"节约"<<n*n-n*(n+1)/2<<"个空间."<<endl;
    }
}
//上、下三角矩阵
void ultma()
{
    while(1)
    {
        int n,a[1000];
        cin>>n;
        cout<<"请输入"<<n*(n+1)/2+1<<"个数:";
        for(int i=0;i<n*(n+1)/2+1;i++)
            cin>>a[i];
     //上三角
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            if(i<=j)
                cout<<setw(3)<<a[(2*n-i+1)*i/2+(j-i)]<<" ";
            else
                cout<<setw(3)<<a[n*(n+1)/2]<<" ";
        }
        cout<<endl;
    }
    cout<<"节约"<<n*n-n*(n+1)/2-1<<"个空间."<<endl;
    }
    //下三角
     /*for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            if(i>=j)
                cout<<setw(3)<<a[i*(i+1)/2+j]<<" ";
            else
                cout<<setw(3)<<a[n*(n+1)/2]<<" ";
        }
        cout<<endl;
    }*/
}
//对角矩阵
void diama()
{
    int n,d,a[100],m;
    cin>>n>>d;
    cout<<"请输入"<<(n*(2*d+1)-d*d-d+1)<<"个数:";
    for(int i=0;i<n*(2*d+1)-d*d-d+1;i++)
        cin>>a[i];
    for(int i=0;i<n;i++)
    {
        for(int j=0;j<n;j++)
        {
            if(fabs(i-j)<=d)
                cout<<setw(3)<<a[(i*(2*d+1)-d)+(j-i+d)]<<" ";
            else
                cout<<setw(3)<<a[n*(2*d+1)-d*d-d]<<" ";
        }
        cout<<endl;
    }
    cout<<"节约"<<n*n-(n*(2*d+1)-d*d-d+1)<<"个空间."<<endl;
}
//稀疏矩阵
void spama()

{

}

int main()
{
    return 0;
}