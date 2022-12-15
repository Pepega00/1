#include <iostream>
#include <fstream>


int main(int argc, char* argv[]){
  if (argc!=3){
    std::cout<<"wrong amount of arguments"<<std::endl;
    return 1;
  }
  std::ifstream infile(argv[1]);
  std::ofstream outfile(argv[2]);
  if (!infile){
    std::cout << "can't open the input file: "<<std::endl;
    return 1;
  }
  if (!outfile){
    std::cout << "can't open the output file: "<<std::endl;
    return 1;
  }
  int nums[100]={0};
  int numcounter=0;
  int counter=0;
  int num=0;
  int answer=0;
  char mychar=' '; 
  char roman[16]={' '};
  while (!infile.eof()){
    infile.get(mychar);
    if (infile.eof() && nums[0]!=0){
      outfile<<" = ";
      if (nums[0]<4000 && nums [0]>0){
        while (nums[0]!=0){
            while (nums[0]>=1000){
              outfile<<'M';
              nums[0]-=1000;
            }
            if (nums[0]>=900){
              outfile<<'C';
              outfile<<'M';
              nums[0]-=900;
            }
            while (nums[0]>=500){
              outfile<<'D';
              nums[0]-=500;
            }
            if (nums[0]>=400){
              outfile<<'C';
              outfile<<'D';
              nums[0]-=400;
            }
            while (nums[0]>=100){
              outfile<<'C';
              nums[0]-=100;
            }
            if (nums[0]>=90){
              outfile<<'X';
              outfile<<'C';
              nums[0]-=90;
            }
            while (nums[0]>=50){
              outfile<<'L';
              nums[0]-=50;
            }
            if (nums[0]>=40){
              outfile<<'X';
              outfile<<'L';
              nums[0]-=40;
            }
            while (nums[0]>=10){
              outfile<<'X';
              nums[0]-=10;
            }
            if (nums[0]>=9){
              outfile<<'I';
              outfile<<'X';
              nums[0]-=9;
            }
            while (nums[0]>=5){
              outfile<<'V';
              nums[0]-=5;
            }
            if (nums[0]>=4){
              outfile<<'I';
              outfile<<'V';
              nums[0]-=4;
            }
            while (nums[0]>=1){
              outfile<<'I';
              nums[0]-=1;
            }
          }
      }
      else{
        outfile<<"ERR";
      }
      return 0;
    }
    if (!infile.eof() && mychar!=' ' && mychar!='+' && mychar!='-' && mychar!='*' && mychar!='/' && mychar!='\n'){
      roman[counter]=mychar;
      counter+=1;
    }
    if (mychar==' ' && roman[0]!=' '){
      for (int i=0;i<counter;i++){
        if (roman [i]=='M'){
          num+=1000;
          if (i>0){
            if (roman [i-1]=='C'){
            num-=200;
            }
          }
        }
        if (roman [i]=='D'){
          num+=500;
          if (i>0){
            if (roman [i-1]=='C'){
            num-=200;
            }
          }
        }
        if (roman [i]=='C'){
          num+=100;
          if (i>0){
            if (roman [i-1]=='X'){
            num-=20;
            }
          }
        }
        if (roman [i]=='L'){
          num+=50;
          if (i>0){
            if (roman [i-1]=='X'){
            num-=20;
            }
          }
        }
        if (roman [i]=='X'){
          num+=10;
          if (i>0){
            if (roman [i-1]=='I'){
            num-=2;
            }
          }
        }
        if (roman [i]=='V'){
          num+=5;
          if (i>0){
            if (roman [i-1]=='I'){
            num-=2;
            }
          }
        }
        if (roman [i]=='I'){
          num+=1;
        }
      }
      if (num!=0){
        nums[numcounter]=num;
        numcounter+=1;
        num=0;
      }
      for (int idx=0;idx<counter;idx++){
        roman[idx]=' ';
      }
      counter=0;
    }
    if (mychar=='+'){
      nums[numcounter-2]=nums[numcounter-2]+nums[numcounter-1];
      nums[numcounter-1]=0;
      numcounter-=1;
    }
    if (mychar=='-'){
      nums[numcounter-2]=nums[numcounter-2]-nums[numcounter-1];
      nums[numcounter-1]=0;
      numcounter-=1;
    }
    if (mychar=='*'){  
      nums[numcounter-2]=nums[numcounter-2]*nums[numcounter-1];
      nums[numcounter-1]=0;
      numcounter-=1;  
    }
    if (mychar=='/'){  
      nums[numcounter-2]=nums[numcounter-2]/nums[numcounter-1];
      nums[numcounter-1]=0;
      numcounter-=1;   
    }
    if (mychar=='\n' && !infile.eof()){
      outfile<<" = ";
      if (nums[0]<4000 && nums [0]>0){
        while (nums[0]!=0){
            while (nums[0]>=1000){
              outfile<<'M';
              nums[0]-=1000;
            }
            if (nums[0]>=900){
              outfile<<'C';
              outfile<<'M';
              nums[0]-=900;
            }
            while (nums[0]>=500){
              outfile<<'D';
              nums[0]-=500;
            }
            if (nums[0]>=400){
              outfile<<'C';
              outfile<<'D';
              nums[0]-=400;
            }
            while (nums[0]>=100){
              outfile<<'C';
              nums[0]-=100;
            }
            if (nums[0]>=90){
              outfile<<'X';
              outfile<<'C';
              nums[0]-=90;
            }
            while (nums[0]>=50){
              outfile<<'L';
              nums[0]-=50;
            }
            if (nums[0]>=40){
              outfile<<'X';
              outfile<<'L';
              nums[0]-=40;
            }
            while (nums[0]>=10){
              outfile<<'X';
              nums[0]-=10;
            }
            if (nums[0]>=9){
              outfile<<'I';
              outfile<<'X';
              nums[0]-=9;
            }
            while (nums[0]>=5){
              outfile<<'V';
              nums[0]-=5;
            }
            if (nums[0]>=4){
              outfile<<'I';
              outfile<<'V';
              nums[0]-=4;
            }
            while (nums[0]>=1){
              outfile<<'I';
              nums[0]-=1;
            }
          }
      }
      else{
        outfile<<"ERR";
      }  
      answer=0;
      numcounter=0;
      for (int numidx=0;numidx<100;numidx++){
        if (nums[numidx]!=0){
        }
        nums[numidx]=0;
      }
    }
    if (!infile.eof()){
      outfile<<mychar;
    }
  }
  infile.close();
  outfile.close();
  return 0;
}
