"use client";
import { useState } from "react";
import { InputForm } from "./components/InputForm";
import { LineGraph } from "./components/LineGraph";

const testData = [
  {
    name: "Value A",
    uv: 4000,
    pv: 2400,
    amt: 2400,
  },
  {
    name: "Value B",
    uv: 3000,
    pv: 1398,
    amt: 2210,
  },
  {
    name: "Value C",
    uv: 2000,
    pv: 9800,
    amt: 2290,
  },
  {
    name: "Value D",
    uv: 2780,
    pv: 3908,
    amt: 2000,
  },
  {
    name: "Value E",
    uv: 1890,
    pv: 4800,
    amt: 2181,
  },
  {
    name: "Value F",
    uv: 2390,
    pv: 3800,
    amt: 2500,
  },
  {
    name: "Value G",
    uv: 3490,
    pv: 4300,
    amt: 2100,
  },
];

export default function Home() {
  // eslint-disable-next-line @typescript-eslint/no-unused-vars
  const [graphData, setGraphData] = useState(null);
  const fetchData = () => {
    fetch("http://localhost:8080/api/investmentWithDepreciation")
      .then((response) => {
        if (response.ok) {
          console.log(response);
          return response.json();
        }
      })
      .then((data) => {
        try {
          const jsonData = JSON.parse(data);
          console.log(jsonData);
          setGraphData(jsonData);
        } catch (error) {
          console.error("Error parsing JSON:", error);
        }
      })
      .catch((error) => console.error("Error fetching data:", error));
  };

  const handleSubmit = () => {
    fetchData();
  };

  return (
    <div className=" flex items-center justify-center ">
      {/* MODAL CONTAINER */}
      <main className="py-20 sm:py-0 flex w-full flex-row sm:rounded-lg sm:m-20 m-10 sm:border-2 sm:shadow-xl overflow-hidden sm:max-w-4xl sm:min-w-fit">
        <div className="flex items-center w-full justify-around bg-white sm:p-10 flex-col sm:flex-row">
          <InputForm handleSubmit={handleSubmit} />
          <div className="flex flex-col justify-center items-center">
            <h1 className="font-bold">Compound Interest Calculator</h1>
            <LineGraph data={testData} />
            {/* <LineGraph data={graphData} /> */}
          </div>
        </div>
      </main>
    </div>
  );
}
