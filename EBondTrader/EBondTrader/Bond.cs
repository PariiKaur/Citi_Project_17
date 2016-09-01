using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.Serialization;

namespace EBondTrader
{
    [DataContract]
    public class Bond
    {
        [DataMember]
        public string bond_ID { get; set; }
        [DataMember]
        public string bond_Type { get; set; }
        [DataMember]
        public double change { get; set; }
        [DataMember]
        public double coupon_Rate { get; set; }
        [DataMember]
        public string credit_Rating { get; set; }
        [DataMember]
        public double high { get; set; }
        [DataMember]
        public string issuer_Name { get; set; }
        [DataMember]
        public double last { get; set; }
        [DataMember]
        public double low { get; set; }
        [DataMember]
        public string maturity_Date { get; set; }
        [DataMember]
        public int serial_ID { get; set; }
        [DataMember]
        public string start_Date { get; set; }
        [DataMember]
        public double yield { get; set; }
        [DataMember]
        public string bond_Currency { get; set; }

        public Bond(string ID, string type, double change, double coupon_Rate, string credit_Rating,
            double high, string issuer_Name,
            double last, double low, string maturity_Date, int serial_ID, string start_Date, double yield,
            string bond_currency)
        {
            bond_ID = ID;
            bond_Type = type;
            this.change = change;
            this.coupon_Rate = coupon_Rate;
            this.credit_Rating = credit_Rating;
            this.high = high;
            this.issuer_Name = issuer_Name;
            this.last = last;
            this.low = low;
            this.maturity_Date = maturity_Date;
            this.serial_ID = serial_ID;
            this.start_Date = start_Date;
            this.yield = yield;
            this.bond_Currency = bond_Currency;
        }

        public override string ToString()
        {
            return bond_ID + "  " + bond_Type + "  " + change;

        }
    }
}
