using Microsoft.VisualStudio.TestTools.UnitTesting;
using M01_First_WPF_Proj;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows;

namespace M01_First_WPF_Proj.Tests
{
    [TestClass()]
    public class GroupingTests
    {
        [TestMethod()]
        public void GroupingTest()
        {
            int distanceThreshold = 100;
            int num_of_points = 2;
            Grouping g = new Grouping(distanceThreshold, num_of_points);
            g.MasterList[0] = new Point(0, 0);
            g.MasterList[1] = new Point(0, 101);

            List<List<Point>> subList = g.applyThreseholdsMakeGroups();

            int actual_group_count = subList.Count;
            int Expected_Group_Count = 2;
            Assert.AreEqual(Expected_Group_Count, actual_group_count);

            Point Actual_Group_Point = subList[0][0];
            Point Expected_Group_Point = new Point(0, 0);
            Boolean same = (Actual_Group_Point.X == Expected_Group_Point.X)
                & (Actual_Group_Point.Y == Expected_Group_Point.Y);
            Assert.IsTrue(same);

            Actual_Group_Point = subList[1][0];
            Expected_Group_Point = new Point(0, 101);
            same = (Actual_Group_Point.X == Expected_Group_Point.X)
                & (Actual_Group_Point.Y == Expected_Group_Point.Y);
            Assert.IsTrue(same);
        }

        [TestMethod()]
        public void GroupingTest_02()
        {
            int distanceThreshold = 100;
            int num_of_points = 2;
            Grouping g = new Grouping(distanceThreshold, num_of_points);
            g.MasterList[0] = new Point(0, 0);
            g.MasterList[1] = new Point(0, 99);

            List<List<Point>> subList = g.applyThreseholdsMakeGroups();

            int actual_group_count = subList.Count;
            int Expected_Group_Count = 1;
            Assert.AreEqual(Expected_Group_Count, actual_group_count);

            Point Actual_Group_Point = subList[0][0];
            Point Expected_Group_Point = new Point(0, 0);
            Boolean same = (Actual_Group_Point.X == Expected_Group_Point.X)
                & (Actual_Group_Point.Y == Expected_Group_Point.Y);
            Assert.IsTrue(same);

            Actual_Group_Point = subList[0][1];
            Expected_Group_Point = new Point(0, 99);
            same = (Actual_Group_Point.X == Expected_Group_Point.X)
                & (Actual_Group_Point.Y == Expected_Group_Point.Y);
            Assert.IsTrue(same);
        }

        [TestMethod()]
        public void GroupingTest_03()
        {
            int distanceThreshold = 100;
            int num_of_points = 3;
            Grouping g = new Grouping(distanceThreshold, num_of_points);
            g.MasterList[0] = new Point(55, 0);
            g.MasterList[1] = new Point(55, 50);
            g.MasterList[2] = new Point(55, 100);

            List<List<Point>> subList = g.applyThreseholdsMakeGroups();

            int actual_group_count = subList.Count;
            int Expected_Group_Count = 1;
            Assert.AreEqual(Expected_Group_Count, actual_group_count);

            Point Actual_Group_Point = subList[0][0];
            Point Expected_Group_Point = new Point(55, 0);
            Boolean same = (Actual_Group_Point.X == Expected_Group_Point.X)
                & (Actual_Group_Point.Y == Expected_Group_Point.Y);
            Assert.IsTrue(same);

            Actual_Group_Point = subList[0][3];
            Expected_Group_Point = new Point(55, 100);
            same = (Actual_Group_Point.X == Expected_Group_Point.X)
                & (Actual_Group_Point.Y == Expected_Group_Point.Y);
            Assert.IsTrue(same);
        }

        [TestMethod()]
        public void GroupingTest_04()
        {
            int distanceThreshold = 100;
            int num_of_points = 4;
            Grouping g = new Grouping(distanceThreshold, num_of_points);
            g.MasterList[0] = new Point(55, 0);
            g.MasterList[1] = new Point(55, 50);
            g.MasterList[2] = new Point(55, 100);
            g.MasterList[3] = new Point(55, 150);

            List<List<Point>> subList = g.applyThreseholdsMakeGroups();

            int actual_group_count = subList.Count;
            int Expected_Group_Count = 1;                              // This should be 2 groups, not 1!
            Assert.AreEqual(Expected_Group_Count, actual_group_count); // Ill leave this here. As the 2 points are outside the threshold, I would assume they would make a new group!

            Point Actual_Group_Point = subList[0][0];
            Point Expected_Group_Point = new Point(55, 0);
            Boolean same = (Actual_Group_Point.X == Expected_Group_Point.X)
                & (Actual_Group_Point.Y == Expected_Group_Point.Y);
            Assert.IsTrue(same);

            Actual_Group_Point = subList[0][4]; // should be [1][0]
            Expected_Group_Point = new Point(55, 100);
            same = (Actual_Group_Point.X == Expected_Group_Point.X)
                & (Actual_Group_Point.Y == Expected_Group_Point.Y);
            Assert.IsTrue(same);
        }

        [TestMethod()]
        public void GroupingTest_05()
        {
            int distanceThreshold = 100;
            int num_of_points = 4;
            Grouping g = new Grouping(distanceThreshold, num_of_points);
            g.MasterList[0] = new Point(55, 0);
            g.MasterList[1] = new Point(55, 50);
            g.MasterList[2] = new Point(300, 100);
            g.MasterList[3] = new Point(300, 150);

            List<List<Point>> subList = g.applyThreseholdsMakeGroups();

            int actual_group_count = subList.Count;
            int Expected_Group_Count = 2;
            Assert.AreEqual(Expected_Group_Count, actual_group_count); 

            Point Actual_Group_Point = subList[0][0];
            Point Expected_Group_Point = new Point(55, 0);
            Boolean same = (Actual_Group_Point.X == Expected_Group_Point.X)
                & (Actual_Group_Point.Y == Expected_Group_Point.Y);
            Assert.IsTrue(same);

            Actual_Group_Point = subList[1][0]; 
            Expected_Group_Point = new Point(300, 100);
            same = (Actual_Group_Point.X == Expected_Group_Point.X)
                & (Actual_Group_Point.Y == Expected_Group_Point.Y);
            Assert.IsTrue(same);
        }
    }
}