using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.Serialization;
namespace EBondTrader
{
    [DataContract]
    public class Trade
    {
        [DataMember]
        public int order_ID { get; set; }
        [DataMember]
        public double trade_Amount { get; set; }
        [DataMember]
        public string trade_Date { get; set; }
        [DataMember]
        public double trade_Price { get; set; }
        [DataMember]
        public string trade_Type { get; set; }
        [DataMember]
        public int trade_Volume { get; set; }

        public Trade(int order_ID, double trade_Amount, string trade_Date, double trade_Price, string trade_Type, int trade_Volume)
        {
            this.order_ID = order_ID;
            this.trade_Amount = trade_Amount;
            this.trade_Price = trade_Price;
            this.trade_Type = trade_Type;
            this.trade_Volume = trade_Volume;
        }
        public override string ToString()
        {
            return " hello ";
        }

    }
}