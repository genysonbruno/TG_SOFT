package com.tgsoft.tg_soft.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    private final ClienteService clienteService;
    private final ObjectMapper mapper = new ObjectMapper();

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping()
    public ResponseEntity<List<Cliente>>  listar(){
        return new ResponseEntity<>(clienteService.listar(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> ler(@PathVariable("id") Long id){
        return new ResponseEntity<>(clienteService.getCliente(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<IncluirClienteResponse> incluir(@RequestParam String clienteData, @RequestParam("file") final MultipartFile file){

    }
}
