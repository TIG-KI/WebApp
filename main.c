#include <stdio.h>
#include <stdlib.h>
#include<string.h>

int main()
{
    char
    char a[100];
    int b[100];
    int nub;
    scanf("%s",a);
    int l=strlen(a);
    printf("%d\n",l);
    int sum=0;
    for(int i=0;i<l;i++)
    {
        b[i]=a[i]-'0';
    }
    for(int i=0;i<l;i++)
    {
        sum+=b[i];
    }
    printf("%d",sum);
}
