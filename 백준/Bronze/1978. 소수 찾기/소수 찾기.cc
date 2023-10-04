//
//  main.c
//  Structure
//
//  Created by 정원영 on 2022/12/14.
//

#include <stdio.h>
int Sosu(int num1){
    int count = 0;
    for(int i=1; i<=num1; i++){
        if(num1%i == 0){
            count++;
        }
    }
    if(count==2){
        return 1;
    }
    else{
        return 0;
    }
}

int main(){
    int size=0, count=0;
    int arr[100];
    scanf("%d", &size);
    
    for(int i=0; i<size; i++){
        scanf("%d", arr+i);
    }
    
    for(int i=0; i<size; i++){
        count += Sosu(arr[i]);
    }
    
    printf("%d", count);
}
