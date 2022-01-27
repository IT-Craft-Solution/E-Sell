-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 26, 2022 at 06:24 PM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 7.4.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `olxdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `name`, `username`, `password`, `email`) VALUES
(1, 'akshay', 'akshay', 'akshay', 'kherakshay007@gmail.com'),
(2, 'akshay', 'akshay', 'akshay', 'kherakshay007@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `category`
--

CREATE TABLE `category` (
  `id` int(255) NOT NULL,
  `cat_name` varchar(255) NOT NULL,
  `cat_img` varchar(255) NOT NULL,
  `status` int(255) NOT NULL,
  `added_on` datetime NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `category`
--

INSERT INTO `category` (`id`, `cat_name`, `cat_img`, `status`, `added_on`) VALUES
(4, 'HondaCity', 'demo.png', 0, '2022-01-26 22:06:37'),
(5, 'Bike', 'demo.png', 1, '2022-01-25 22:13:49'),
(6, 'demo', 'WhatsApp Image 2021-09-02 at 10.20.13 PM.jpeg', 1, '2022-01-26 10:11:24'),
(8, 'prathvik', 'food1.jpg', 0, '2022-01-26 10:13:18'),
(9, 'karan', 'WhatsApp Image 2021-09-02 at 10.20.13 PM.jpeg', 0, '2022-01-26 10:13:29'),
(11, 'demo here', 'WhatsApp Image 2021-09-02 at 10.20.13 PM.jpeg', 0, '2022-01-26 11:13:14'),
(12, 'cool', 'WhatsApp Image 2021-09-02 at 10.20.13 PM.jpeg', 1, '2022-01-26 11:13:41'),
(13, 'aaaaaaaaaaa', 'meal-monkey.png', 1, '2022-01-26 12:08:35'),
(14, 'hitbhakher', 'WhatsApp Image 2021-09-02 at 10.20.13 PM.jpeg', 1, '2022-01-26 12:10:36'),
(16, 'ajay', 'WhatsApp Image 2021-09-02 at 10.20.13 PM.jpeg', 1, '2022-01-26 15:17:00'),
(19, 'newUpdatedNmaeHere', 'hello.png', 1, '2022-01-26 21:56:54');

-- --------------------------------------------------------

--
-- Table structure for table `sell`
--

CREATE TABLE `sell` (
  `id` int(255) NOT NULL,
  `cat_name` varchar(255) NOT NULL,
  `title` varchar(255) NOT NULL,
  `description` varchar(255) NOT NULL,
  `price` varchar(255) NOT NULL,
  `location` varchar(255) NOT NULL,
  `city_area` varchar(255) NOT NULL,
  `item_img` varchar(255) NOT NULL,
  `added_on` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `status` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `sell`
--

INSERT INTO `sell` (`id`, `cat_name`, `title`, `description`, `price`, `location`, `city_area`, `item_img`, `added_on`, `status`) VALUES
(2, 'car', 'swift', 'new swift car', '1lakh', 'Rajkot', 'kalavad Road', 'demo.png', '2022-01-25 16:41:57', 1),
(3, 'Mercidish', '', '', '11', '', 'djdnj', 'demo.png', '2022-01-26 17:02:11', 0),
(7, 'demo', 'demo', 'demo', '111', 'rajkot', 'rajherekot', '', '2022-01-26 10:47:39', 1),
(8, 'scoter', 'scoter is here', '2nd hand scoter', '10k', 'rajkot', 'kalavad Road', 'demo.png', '2022-01-26 16:46:05', 1);

-- --------------------------------------------------------

--
-- Table structure for table `user_details`
--

CREATE TABLE `user_details` (
  `id` int(255) NOT NULL,
  `phone` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `user_img` varchar(255) NOT NULL,
  `user_name` varchar(255) NOT NULL,
  `user_bio` varchar(255) NOT NULL,
  `added_on` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `location` varchar(255) NOT NULL,
  `city_area` varchar(255) NOT NULL,
  `status` int(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `user_details`
--

INSERT INTO `user_details` (`id`, `phone`, `email`, `user_img`, `user_name`, `user_bio`, `added_on`, `location`, `city_area`, `status`) VALUES
(2, '+91 6356645049', 'kherakshay007@gmail.com', 'logo2.png', 'akshay', 'android developer', '2022-01-25 16:33:26', 'rajkot', 'kalavad Road', 1),
(5, 'akshay', 'kherakshay007@gmail.com', 'logo2.png', 'akshay', 'android developer', '2022-01-26 11:13:41', 'rajkot', 'kalavad Road', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `sell`
--
ALTER TABLE `sell`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `user_details`
--
ALTER TABLE `user_details`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `category`
--
ALTER TABLE `category`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `sell`
--
ALTER TABLE `sell`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `user_details`
--
ALTER TABLE `user_details`
  MODIFY `id` int(255) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
