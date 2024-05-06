using System;
using System.Collections;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using static System.Runtime.InteropServices.JavaScript.JSType;

namespace Lab3
{
    internal class MySet
    {
        private List<float> _list;
        public string name;

        public List<float> List 
        {
            set { _list = value; }
            get { return _list; } 
        }
        
        public MySet(string name, bool initialize=false) 
        {
            this.name = name;
            _list = new List<float>();
            if (initialize)
            {
                _list.Add(1.0f);
                _list.Add(2.0f);
                _list.Add(3.0f);

            }

        }

        public void Add(float value)
        {
            if (!(_list.Contains(value)))
            {
                _list.Add(value);

            }
            else
            {
                Console.WriteLine($"{value} is already in {this.name}");
            }

        }
        public void PrintValues()
        {
            Console.WriteLine($"{this.name} elements:");

            foreach (var item in _list)
            {
                Console.WriteLine(item);

            }
        }
        public void Remove(float number)
        {
            _list.Remove(number);
            Console.WriteLine($"{number} was removed from {this.name}");

        }
        public bool Contains(float number) {
            if (!_list.Contains(number))
            {
                return false;
            }
            return true;

        }
        public void Intersection(MySet obj)
        {
            Console.WriteLine($"What {this.name}'s elements intersect with {obj.name}?");
                        List<float> intersection = new List<float>();
            foreach (var item in _list)
            {
                if (obj.Contains(item))
                {

                    intersection.Add(item);
                }

            }
            if (intersection.Count == 0)
            {
                Console.WriteLine("No common items");
            }
            else
            {
                foreach (var item in intersection)
                {
                    Console.WriteLine(item);
                }
            }
        }
        public bool Equals(MySet obj)
        {
            Console.WriteLine($"Does {this.name} equal {obj.name}?");

            if (_list.Count != obj._list.Count) return false;
            for (int i = 0; i < _list.Count; i++)
            {
                if (!(_list.Contains(obj._list[i])))
                {
                    return false;

                }
                            }

            return true;
        }



    }
}
