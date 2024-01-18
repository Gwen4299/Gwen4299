#include<iostream>
using namespace std;
int main()
{
      // currency equivalence to one dollar
            float dollar;
            float GHS=(11.9535);
            float NGN=(890.6189);
            float UGX=(3,785.2174);
            float GMD=(67.5967);
            float ZAR=(18.3154);
            cout<<"Enter currency in dollars :\n";
            cin>>dollar;

     // currency conversion from dollars
            cout<<"Ghana Cedis: "<<GHS*dollar<<endl;
            cout<<"Nigerian Naira: "<<NGN*dollar<<endl;
            cout<<"Ugandan Shilling: "<<UGX*dollar<<endl;
            cout<<"Gambian Dalasi: "<<GMD*dollar<<endl;
            cout<<"South African Rand: "<<ZAR*dollar<<endl;
            return 0;
}
