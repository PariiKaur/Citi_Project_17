using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.Serialization;

namespace EBondTrader
{
    [DataContract]
    class ResultRecompute
    {
        [DataMember]
        public double yield { get; set; }
        [DataMember]
        public double dirtyPrice { get; set; }
        [DataMember]
        public double accruedInterest { get; set; }
        [DataMember]
        public double settledAmount { get; set; }
        public ResultRecompute(double cleanPrice, double dirtyPrice, double accruedInterest, double settledAmount)
        {
            this.yield = yield;
            this.dirtyPrice = dirtyPrice;
            this.accruedInterest = accruedInterest;
            this.settledAmount = settledAmount;
        }
        public override string ToString()
        {
            return " " + yield + " ";
        }

    }
}
