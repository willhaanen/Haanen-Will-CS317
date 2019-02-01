
 #include <iostream>
 #include <stdlib.h>
 #include <time.h>
 #include <math.h>

 

 double newNumber() {
  double num;
   
  num = ((double)rand()/(double)RAND_MAX) - 0.5;

  return num;
}
 double standDev(double avgs[], double mean, int numGames) {
 double sum = 0;
 double sum2 = 0;
 double stDev;
 double sqDiffs [numGames];
 for( int i = 0; i < numGames; i = i + 1) {
   sqDiffs [i] = pow ((avgs [i] - mean), 2);
 }
 for( int j = 0; j < numGames; j = j + 1){
  sum2 = sum2 + sqDiffs [j];
 }
 stDev = sqrt(sum2/numGames);
 return stDev;
}

int main() {
 double sum = 0;
 double numThrows;
 int numGames;
 std::cout<<"Enter number of games: ";
 std::cin>> numGames;
 //std::cout<<numGames<<"\n";
 double gameAvgs [numGames];
 std::cout<< "Enter number of throws per game: ";
 std::cin>> numThrows;
 //std::cout<< numThrows<<" b4 for\n";
 for (int j = 0; j < numGames; j++) {
  //std::cout<<"Index is "<<j<<"\n";
  double hits = 0.0;
  for( int i = 0; i < numThrows; i = i + 1) {
   //std::cout<<"Index 2 is "<<i<<"\n";
   double x = newNumber();
   double y = newNumber();
   //std::cout<<"x: "<<x<<"y: "<<y<<"\n";
   double d = sqrt((x*x)+(y*y));
   //std::cout<<"Distance: "<<d<<"\n";
   if (d < 0.5) {
   hits = hits + 1.0;
   }
  }
  double avg = 4.0 * (hits/numThrows);
  gameAvgs [j] = avg;
  sum = sum + avg;
  //std::cout<<"Avg: "<<avg<<"\n";
  //std::cout<<"Hits: "<<hits<<"\n";
 }
 //std::cout<<"test";
 double mean = sum/numGames;
 double stDev = standDev(gameAvgs, mean, numGames);
 std::cout<<"Mean: " << mean;
 std::cout<<"\nStandard Deviation: "<< stDev<<"\n";

}
