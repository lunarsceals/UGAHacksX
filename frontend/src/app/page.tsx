"use client";
import { LineGraph } from "./components/LineGraph";
// import { BarGraph } from "./components/BarGraph";

import { useState } from "react";
// const data = [
//   {
//     name: "Page A",
//     uv: 4000,
//     pv: 2400,
//     amt: 2400,
//   },
//   {
//     name: "Page B",
//     uv: 3000,
//     pv: 1398,
//     amt: 2210,
//   },
//   {
//     name: "Page C",
//     uv: 2000,
//     pv: 9800,
//     amt: 2290,
//   },
//   {
//     name: "Page D",
//     uv: 2780,
//     pv: 3908,
//     amt: 2000,
//   },
//   {
//     name: "Page E",
//     uv: 1890,
//     pv: 4800,
//     amt: 2181,
//   },
//   {
//     name: "Page F",
//     uv: 2390,
//     pv: 3800,
//     amt: 2500,
//   },
//   {
//     name: "Page G",
//     uv: 3490,
//     pv: 4300,
//     amt: 2100,
//   },
// ];

export default function Home() {
  const [data, setData] = useState(null);
  const [inputData, setInputData] = useState("");

  const fetchData = () => {
    fetch("http://localhost:8080/api/investment")
      .then((response) => {
        console.log(response);
        return response.text();
      })
      .then((data) => {
        try {
          const jsonData = JSON.parse(data);
          setData(jsonData);
        } catch (error) {
          console.error("Error parsing JSON:", error);
        }
      })
      .catch((error) => console.error("Error fetching data:", error));
  };

  // const handleSubmit = (e: FormEvent<SubmitEvent>) => {
  //   e.preventDefault();
  //   const postData = { data: inputData };

  //   fetch("/api/data", {
  //     method: "POST",
  //     headers: {
  //       "Content-Type": "application/json",
  //     },
  //     body: JSON.stringify(postData),
  //   })
  //     .then((response) => response.json())
  //     .then((data) => console.log("Success:", data))
  //     .catch((err) => console.error("Error posting data:", err));

  return (
    <div className="pt-96">
      <main>
        {/* <button className="ring-1 rounded-sm" onClick={fetchData}>
          Fetch
        </button> */}
        {data && <LineGraph data={data} />}
        {data && <pre>{JSON.stringify(data, null, 2)}</pre>}
        {/* <BarGraph data={data} /> */}
      </main>
    </div>
  );
}
