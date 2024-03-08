﻿using Microsoft.VisualStudio.TestTools.UnitTesting;
using Cube3D;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Cube3D.Tests
{
    [TestClass()]
    public class GroupingTests
    {
        [TestMethod()]
        public void GetGroupTest_01()
        {
            int distanceThreshold = 100;
            int num_of_points = 2;
            Grouping g = null;
            g = new Grouping(distanceThreshold, num_of_points);  // size of master list generated
            g.MasterList[0] = new Dot(0, 0, 0);  // Replace random points to these
            g.MasterList[1] = new Dot(0, 0, 101);

            // each sublist is a grouping
            List<List<Dot>> sublists = g.applyThreseholdsMakeGroups();

            // Num of groups
            int Actual_Group_Count = sublists.Count;
            int Expected_Group_Count = 2; // expected 2 points not grouped
            Assert.AreEqual(Expected_Group_Count, Actual_Group_Count);

            // 1st group?
            Dot Actual_Group_Point = sublists[0][0];  // 1st and only Point of group 01
            Dot Expected_Group_Point = new Dot(0, 0, 0); // expected Point of group 01
            Boolean same = (Actual_Group_Point.X == Expected_Group_Point.X)
                & (Actual_Group_Point.Y == Expected_Group_Point.Y)
                & (Actual_Group_Point.Z == Expected_Group_Point.Z);
            Assert.IsTrue(same);  // Are points same?

            // 2nd group?
            Actual_Group_Point = sublists[1][0];  // 1st and only Point of group 01
            Expected_Group_Point = new Dot(0, 0, 101); // expected Point of group 01
            same = (Actual_Group_Point.X == Expected_Group_Point.X)
                & (Actual_Group_Point.Y == Expected_Group_Point.Y)
                & (Actual_Group_Point.Z == Expected_Group_Point.Z);
            Assert.IsTrue(same);  // Are points same?
        }

        [TestMethod()]
        public void GetGroupTest_02()
        {
            int distanceThreshold = 100;
            int num_of_points = 2;
            Grouping g = null;
            g = new Grouping(distanceThreshold, num_of_points);  // size of master list generated
            g.MasterList[0] = new Dot(10, 10, 110);  // Replace random points to these
            g.MasterList[1] = new Dot(10, 10, 200);

            // each sublist is a grouping
            List<List<Dot>> sublists = g.applyThreseholdsMakeGroups();

            // Num of groups
            int Actual_Group_Count = sublists.Count;
            int Expected_Group_Count = 1;
            Assert.AreEqual(Expected_Group_Count, Actual_Group_Count);

            // 1st group?
            Dot Actual_Group_Point = sublists[0][0];  // 1st and only Point of group 01
            Dot Expected_Group_Point = new Dot(10, 10, 110); // expected Point of group 01 same as g.MasterList[0]
            Boolean same = (Actual_Group_Point.X == Expected_Group_Point.X)
                & (Actual_Group_Point.Y == Expected_Group_Point.Y)
                & (Actual_Group_Point.Z == Expected_Group_Point.Z);
            Assert.IsTrue(same);  // Are points same?

            // 2nd group?
            Actual_Group_Point = sublists[0][1];  // 1st and only Point of group 01
            Expected_Group_Point = new Dot(10, 10, 200); // expected Point of group 01
            same = (Actual_Group_Point.X == Expected_Group_Point.X)
                & (Actual_Group_Point.Y == Expected_Group_Point.Y)
                & (Actual_Group_Point.Z == Expected_Group_Point.Z);
            Assert.IsTrue(same);  // Are points same?
        }

        [TestMethod()]
        public void GetGroupTest_03()
        {
            int distanceThreshold = 100;
            int num_of_points = 3;
            Grouping g = null;
            g = new Grouping(distanceThreshold, num_of_points);  // size of master list generated
            g.MasterList[0] = new Dot(100, 105, 100);  // Replace random points to these
            g.MasterList[1] = new Dot(100, 105, 150);
            g.MasterList[2] = new Dot(100, 105, 200);

            // each sublist is a grouping
            List<List<Dot>> sublists = g.applyThreseholdsMakeGroups();

            // Num of groups
            int Actual_Group_Count = sublists.Count;
            int Expected_Group_Count = 1; // expected 1 points not grouped
            Assert.AreEqual(Expected_Group_Count, Actual_Group_Count);

            // 1st group?
            Dot Actual_Group_Point = sublists[0][0];  // 1st and only Point of group 01
            Dot Expected_Group_Point = new Dot(100, 105, 100); // expected Point of group 01 same as g.MasterList[0]
            Boolean same = (Actual_Group_Point.X == Expected_Group_Point.X)
                & (Actual_Group_Point.Y == Expected_Group_Point.Y)
                & (Actual_Group_Point.Z == Expected_Group_Point.Z);
            Assert.IsTrue(same);  // Are points same?

            // 2nd group?
            Actual_Group_Point = sublists[0][3];  // 1st and only Point of group 01
            Expected_Group_Point = new Dot(100, 105, 200); // expected Point of group 01
            same = (Actual_Group_Point.X == Expected_Group_Point.X)
                & (Actual_Group_Point.Y == Expected_Group_Point.Y)
                & (Actual_Group_Point.Z == Expected_Group_Point.Z);
            Assert.IsTrue(same);  // Are points same?
        }

        [TestMethod()]
        public void GetGroupTest_04()
        {
            int distanceThreshold = 100;
            int num_of_points = 4;
            Grouping g = null;
            g = new Grouping(distanceThreshold, num_of_points);  // size of master list generated
            g.MasterList[0] = new Dot(100, 105, 100);  // Replace random points to these
            g.MasterList[1] = new Dot(100, 105, 150);
            g.MasterList[2] = new Dot(100, 105, 200);
            g.MasterList[3] = new Dot(100, 105, 175);

            // each sublist is a grouping
            List<List<Dot>> sublists = g.applyThreseholdsMakeGroups();

            // Num of groups
            int Actual_Group_Count = sublists.Count;
            int Expected_Group_Count = 1; // expected 1 points not grouped
            Assert.AreEqual(Expected_Group_Count, Actual_Group_Count);

            // 1st group?
            Dot Actual_Group_Point = sublists[0][0];  // 1st and only Point of group 01
            Dot Expected_Group_Point = new Dot(100, 105, 100); // expected Point of group 01 same as g.MasterList[0]
            Boolean same = (Actual_Group_Point.X == Expected_Group_Point.X)
                & (Actual_Group_Point.Y == Expected_Group_Point.Y)
                & (Actual_Group_Point.Z == Expected_Group_Point.Z);
            Assert.IsTrue(same);  // Are points same?

            // 2nd group?
            Actual_Group_Point = sublists[0][4];  // 1st and only Point of group 01
            Expected_Group_Point = new Dot(100, 105, 200); // expected Point of group 01
            same = (Actual_Group_Point.X == Expected_Group_Point.X)
                & (Actual_Group_Point.Y == Expected_Group_Point.Y)
                & (Actual_Group_Point.Z == Expected_Group_Point.Z);
            Assert.IsTrue(same);  // Are points same?
        }

        [TestMethod()]
        public void GetGroupTest_05()
        {
            int distanceThreshold = 100;
            int num_of_points = 4;
            Grouping g = null;
            g = new Grouping(distanceThreshold, num_of_points);  // size of master list generated
            g.MasterList[0] = new Dot(100, 105, 100);  // Replace random points to these
            g.MasterList[1] = new Dot(100, 105, 150);
            g.MasterList[2] = new Dot(200, 150, 200);
            g.MasterList[3] = new Dot(200, 150, 175);

            // each sublist is a grouping
            List<List<Dot>> sublists = g.applyThreseholdsMakeGroups();

            // Num of groups
            int Actual_Group_Count = sublists.Count;
            int Expected_Group_Count = 2; // expected 1 points not grouped
            Assert.AreEqual(Expected_Group_Count, Actual_Group_Count);

            // 1st group?
            Dot Actual_Group_Point = sublists[0][0];  // 1st and only Point of group 01
            Dot Expected_Group_Point = new Dot(100, 105, 100); // expected Point of group 01 same as g.MasterList[0]
            Boolean same = (Actual_Group_Point.X == Expected_Group_Point.X)
                & (Actual_Group_Point.Y == Expected_Group_Point.Y)
                & (Actual_Group_Point.Z == Expected_Group_Point.Z);
            Assert.IsTrue(same);  // Are points same?

            // 2nd group?
            Actual_Group_Point = sublists[1][0];  // 1st and only Point of group 01
            Expected_Group_Point = new Dot(200, 150, 200); // expected Point of group 01
            same = (Actual_Group_Point.X == Expected_Group_Point.X)
                & (Actual_Group_Point.Y == Expected_Group_Point.Y)
                & (Actual_Group_Point.Z == Expected_Group_Point.Z);
            Assert.IsTrue(same);  // Are points same?
        }
    }
}