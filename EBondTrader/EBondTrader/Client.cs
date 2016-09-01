using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Runtime.Serialization;

namespace EBondTrader
{
    [DataContract]
    public class Client
    {
        [DataMember]
        public int client_Id { get; set; }
        [DataMember]
        public string first_Name { get; set; }
        [DataMember]
        public string last_Name { get; set; }
        [DataMember]
        public string email { get; set; }
        [DataMember]
        public int phone { get; set; }

        public Client(int client_Id, string first_Name, string last_Name,string email, int phone)
        {
            this.client_Id = client_Id;
            this.first_Name = first_Name;
            this.last_Name = last_Name;
            this.email = email;
            this.phone = phone;
        }
        public override string ToString()
        {
            return " "+client_Id+"\n"+first_Name+"\n"+last_Name+"\n"+email+"\n"+phone;
        }
    }
}
