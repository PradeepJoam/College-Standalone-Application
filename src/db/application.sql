-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Jan 22, 2019 at 10:12 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `application`
--

-- --------------------------------------------------------

--
-- Table structure for table `dept`
--

CREATE TABLE IF NOT EXISTS `dept` (
  `deptid` varchar(40) NOT NULL,
  `deptname` varchar(40) DEFAULT NULL,
  `depthead` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`deptid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dept`
--

INSERT INTO `dept` (`deptid`, `deptname`, `depthead`) VALUES
('comp101', 'computer_science', 'PradeepJoam');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `stid` varchar(40) NOT NULL,
  `teachid` varchar(40) DEFAULT NULL,
  `stname` varchar(50) DEFAULT NULL,
  `stfname` varchar(40) DEFAULT NULL,
  `stemail` varchar(70) DEFAULT NULL,
  `stpassword` varchar(20) DEFAULT NULL,
  `stclass` varchar(20) DEFAULT NULL,
  `deptid` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`stid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `teacher`
--

CREATE TABLE IF NOT EXISTS `teacher` (
  `teachid` varchar(40) NOT NULL,
  `deptid` varchar(40) DEFAULT NULL,
  `teachname` varchar(50) DEFAULT NULL,
  `teachemail` varchar(70) DEFAULT NULL,
  `teahcpassword` varchar(20) DEFAULT NULL,
  `teachqua` varchar(20) DEFAULT NULL,
  `teachsub` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`teachid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
