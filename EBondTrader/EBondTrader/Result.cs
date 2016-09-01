using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.Serialization;
namespace EBondTrader
{
    [DataContract]
    class Result
    {
        [DataMember]
        public double cleanPrice { get; set; }
        [DataMember]
        public double dirtyPrice { get; set; }
        [DataMember]
        public double accruedInterest { get; set; }
        [DataMember]
        public double settledAmount { get; set; }
        public Result(double cleanPrice,double dirtyPrice,double accruedInterest,double settledAmount)
        {
            this.cleanPrice = cleanPrice;
            this.dirtyPrice = dirtyPrice;
            this.accruedInterest = accruedInterest;
            this.settledAmount = settledAmount;
        }
        public override string ToString()
        {
            return " " + cleanPrice + " ";
        }
    }
}
